package io.objects.tl.poet

import com.fasterxml.jackson.databind.JsonNode
import java.util.*

private val genericRegex = Regex("([a-zA-Z]+)<([a-zA-Z]+)>") // Vector<SomeKindOfType>
private val flagRegex = Regex("([a-zA-Z]+).(\\d+)\\?([a-zA-Z<>.]+)") // flags.0?true
private val rawRegex = Regex("[a-zA-Z].+")

fun buildFromJson(root: JsonNode): TLDefinition {
    println("Reading TL-Schema...")
    val constructorsNode = root["constructors"].filterNot { c ->
        IgnoredTypes.contains(c["type"].textValue())
    }
    val methodsNode = root["methods"]

    val types = HashMap<String, TLTypeRaw>()
    val constructors = ArrayList<TLConstructor>()
    val methods = ArrayList<TLMethod>()

    // First addFileChunk all constructor types: "Abstract classes"
    constructorsNode
            .map { c -> c["type"].textValue() }
            .map { t -> createConstructorType(t) }
            .forEach { tl -> types.put(tl.name, tl) }

    fun JsonNode.getId() = if (isNumber) intValue() else textValue().toInt()
    // Build constructors: type classes
    println("Reading constructors...")
    for (constructor in constructorsNode) {
        val name = constructor["predicate"].textValue()
        val id = constructor["id"].getId()
        val type = constructor["type"].textValue()
        val tlType = types[type]!!

        val constructorParameters = ArrayList<TLParameter>()
        for (p in constructor["params"]) {
            val pName = p["name"]!!.textValue().toString()
            val pType = p["type"]!!.textValue().toString()
            val pTlType = createType(pType, types)

            constructorParameters.add(TLParameter(pName, pTlType))
        }

        constructors.add(TLConstructor(name, id, constructorParameters, tlType))
    }

    // Build constructors: type classes
    println("Reading method...")
    for (method in methodsNode) {
        val name = method.get("method").textValue()
        val id = method["id"].getId()
        val type = method["type"].textValue()
        val tlType = createType(type, types, false)

        val methodParameters = ArrayList<TLParameter>()
        for (p in method["params"]) {
            val pName = p["name"]!!.textValue().toString()
            val pType = p["type"]!!.textValue().toString()
            val pTlType = createType(pType, types)

            methodParameters.add(TLParameter(pName, pTlType))
        }

        methods.add(TLMethod(name, id, methodParameters, tlType))
    }

    return TLDefinition(types, constructors, methods)
}

private fun createConstructorType(typeName: String): TLTypeRaw = when {
    typeName.matches(rawRegex) -> TLTypeRaw(typeName)
    else -> throw RuntimeException("Unsupported type $typeName for constructor/method}")
}

private fun createType(typeName: String,
                       types: Map<String, TLTypeRaw>,
                       isParameter: Boolean = true): TLType =
        when {
            !isParameter && typeName == "X" -> TLTypeAny()
            isParameter && typeName == "!X" -> TLTypeFunctional()
            isParameter && typeName == "#" -> TLTypeFlag()
            isParameter && typeName.matches(flagRegex) -> {
                val groups = flagRegex.matchEntire(typeName)?.groups
                val maskName = groups?.get(1)?.value ?: throw RuntimeException(
                        "Unknown error with type $typeName")
                val value = groups[2]?.value?.toInt() ?: throw RuntimeException(
                        "Unknown error with type $typeName")
                val realType = groups[3]?.value ?: throw RuntimeException(
                        "Unknown error with type $typeName")
                if (maskName != "flags")
                    throw RuntimeException("Unsupported flag name, expected `flags`")

                TLTypeConditional(value, createType(realType, types))
            }
            typeName.matches(genericRegex) -> {
                val groups = genericRegex.matchEntire(typeName)?.groups
                val tlName: String = groups?.get(1)?.value ?: throw RuntimeException(
                        "Unknown error with type $typeName")
                val genericName: String = groups[2]?.value ?: throw RuntimeException(
                        "Unknown error with type $typeName")
                if (!SupportedGenericTypes.contains(tlName)) throw RuntimeException(
                        "Unsupported generic type $tlName")

                TLTypeGeneric(tlName, arrayOf(createType(genericName, types)))
            }
            typeName.matches(rawRegex) -> {
                if (BuiltInTypes.contains(typeName))
                    TLTypeRaw(typeName)
                else if (types.containsKey(typeName))
                    types[typeName]!!
                else throw RuntimeException("Unknown type $typeName")
            }
            else -> throw RuntimeException(
                    "Unsupported type $typeName for ${if (isParameter) "parameter" else "method"}")
        }