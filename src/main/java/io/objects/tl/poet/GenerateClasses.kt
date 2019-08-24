package io.objects.tl.poet

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

const val JAVA_SOURCE_OUTPUT = "./src/main/java"
const val JAVA_TEST_OUTPUT = "./src/test/java"

fun main(args: Array<String>) {
    val TL_SCHEMA_LEVEL = 86

    println("TL Compiler borrowed from Kotlogram (c) 2016 v1.0")
    Runtime.getRuntime().exec("rm -rf $JAVA_SOURCE_OUTPUT/io/objects/tl/api")
    Runtime.getRuntime().exec("rm -rf $JAVA_TEST_OUTPUT/io/objects/tl/api")
    val TL_SCHEMA_PATH = Object::class.java.getResource("/schemas/tl-schema-$TL_SCHEMA_LEVEL.json")
    val tlSchemaNode = ObjectMapper().readValue(TL_SCHEMA_PATH, JsonNode::class.java)
    val definition = buildFromJson(tlSchemaNode)


    TlPoet.writeClasses(definition)
}