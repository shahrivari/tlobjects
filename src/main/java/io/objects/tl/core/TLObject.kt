package io.objects.tl.core

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.TLObjectUtils
import io.objects.tl.exception.InvalidConstructorIdException
import java.io.*
import kotlin.reflect.KMutableProperty0

/**
 * Basic class for all tl-objects. Contains method for serializing and deserializing object.
 * Each tl-object has its own class id to identify object class for deserialization.
 * This number might be unique and often equals to crc32 of tl-record of tl-constructor.
 * See more at [https://core.telegram.org/mtproto/TL](https://core.telegram.org/mtproto/TL)
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
abstract class TLObject : Serializable {
    protected var builder: TLBuilder? = null

    /**
     * @return the constructor id represented by this class
     */
    abstract fun getConstructorId(): Int

    /**
     * Serialize object to byte array
     *
     * @return serialized object with header
     * @throws IOException
     */
    @Throws(IOException::class)
    fun serialize(): ByteArray {
        val stream = ByteArrayOutputStream(computeSerializedSize())
        serialize(stream)
        return stream.toByteArray()
    }

    /**
     * Serialize object to stream
     *
     * @param stream destination stream
     * @throws IOException
     */
    @Throws(IOException::class)
    fun serialize(stream: OutputStream) {
        writeInt(getConstructorId(), stream)
        serializeBody(stream)

        builder?.let {
            if (isFlagNeeded(it))
                writeInt(computeFlags(it), stream)

            it.list.forEach { serializeFields(it, stream) }
        } ?: TODO("should serialize normally")
    }

    private fun serializeFields(it: KMutableProperty0<Any?>, stream: OutputStream) {
        val value = it.get()
        when (getAbsoluteType(it)) {
            "String" -> value?.let { writeString(it as String, stream) }
            "Int" -> value?.let { writeInt(it as Int, stream) }
            "Boolean" -> value?.let { writeBoolean(it as Boolean, stream) }
            "TLIntVector" -> value?.let { writeTLVector(it as TLIntVector, stream) }
            "Double" -> value?.let { writeDouble(it as Double, stream) }
            "TLVector" -> value?.let { writeTLVector(it as TLVector<*>, stream) }
            "TLLongVector" -> value?.let { writeTLVector(it as TLLongVector, stream) }
            "Byte" -> value?.let { writeByte(it as Byte, stream) }
            "ByteArray" -> value?.let { writeByteArray(it as ByteArray, stream) }
            "TLBytes" -> value?.let { writeTLBytes(it as TLBytes, stream) }
            "TLObject" -> value?.let { writeTLObject(it as TLObject, stream) }
            "TLStringVector" -> value?.let {
                writeTLVector(it as TLStringVector, stream)
            }
        }
    }

    private fun computeFlags(it: TLBuilder): Int {
        var flags = 0
        var c = 1

        it.list.forEach {
            val isNullable = isNullable(it)

            if (isNullable) {
                flags = it.get()?.let { flags or c } ?: flags and c.inv()
                c *= 2
            }
        }

        return flags
    }

    private fun getAbsoluteType(it: KMutableProperty0<Any?>): String {
        var type = getType(it)
        val last = getLastCharacter(it)
        if (last == "?") type = type.substring(0, type.lastIndex)
        if (type.toCharArray().last().toString() == ">")
            type = "TLVector"
        return type
    }

    private fun isFlagNeeded(it: TLBuilder): Boolean =
            it.list.map { isNullable(it) }.contains(true)

    private fun isNullable(it: KMutableProperty0<Any?>): Boolean =
            getLastCharacter(it) == "?"

    private fun getLastCharacter(it: KMutableProperty0<Any?>) =
            gerReturnType(it).toCharArray().last().toString()

    private fun getType(it: KMutableProperty0<Any?>): String =
            gerReturnType(it).split(".").last()

    private fun gerReturnType(it: KMutableProperty0<Any?>) =
            it.returnType.toString()

    /**
     * Deserialize object from stream and current TLContext
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    @Throws(IOException::class)
    fun deserialize(stream: InputStream, context: TLContext) {
        val constructorId = readInt(stream)
        if (constructorId != constructorId)
            throw InvalidConstructorIdException(constructorId, constructorId)
        deserializeBody(stream, context)
    }

    /**
     * Serialize object body to stream
     *
     * @param stream destination stream
     * @throws IOException
     */
    @Throws(IOException::class)
    open fun serializeBody(stream: OutputStream) {

    }

    /**
     * Deserialize object from stream and context
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    @Throws(IOException::class)
    open fun deserializeBody(stream: InputStream, context: TLContext) {
        builder?.let {
            val isNeededFlag = isFlagNeeded(it)

            if (isNeededFlag) {
                val flags = readInt(stream)
                var c = 1

                it.list.forEach {
                    val type = getAbsoluteType(it)
                    val isNullable = isNullable(it)

                    if (isNullable) {
                        when (type) {
                            "String" -> {
                                val value =
                                        if ((flags and c) != 0) readTLString(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "Int" -> {
                                val value = if ((flags and c) != 0) readInt(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "Boolean" -> {
                                val value =
                                        if ((flags and c) != 0) readTLBool(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "TLBool" -> {
                                val value =
                                        if ((flags and c) != 0) readTLBool(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "TLIntVector" -> {
                                val value =
                                        if ((flags and c) != 0) readTLIntVector(stream, context)
                                        else null
                                it.set(value)
                                c *= 2
                            }

                            "Double" -> {
                                val value =
                                        if ((flags and c) != 0) readDouble(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "TLVector" -> {
                                val value =
                                        if ((flags and c) != 0) readTLVector(stream, context)
                                        else null
                                it.set(value)
                                c *= 2
                            }

                            "TLLongVector" -> {
                                val value =
                                        if ((flags and c) != 0) readTLLongVector(stream, context)
                                        else null
                                it.set(value)
                                c *= 2
                            }

                            "TLStringVector" -> {
                                val value =
                                        if ((flags and c) != 0) readTLStringVector(stream, context)
                                        else null
                                it.set(value)
                                c *= 2
                            }

                            "Byte" -> {
                                val value =
                                        if ((flags and c) != 0) readByte(stream).toByte() else null
                                it.set(value)
                                c *= 2
                            }

                            "ByteArray" -> {
                                val value =
                                        if ((flags and c) != 0) readByteArray(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "TLBytes" -> {
                                val value =
                                        if ((flags and c) != 0) readTLBytes(stream) else null
                                it.set(value)
                                c *= 2
                            }

                            "TLObject" -> {
                                val value =
                                        if ((flags and c) != 0) readTLObject(stream, context)
                                        else null
                                it.set(value)
                                c *= 2
                            }
                        }
                    } else
                        deserializeNonNullable(type, stream, it, context)
                }
            } else
                it.list.forEach { deserializeNonNullable(getAbsoluteType(it), stream, it, context) }
        }
    }

    private fun deserializeNonNullable(type: String,
                                       stream: InputStream,
                                       it: KMutableProperty0<Any?>,
                                       context: TLContext) {
        when (type) {
            "String" -> it.set(readTLString(stream))
            "Int" -> it.set(readInt(stream))
            "Boolean" -> it.set(readTLBool(stream))
            "TLIntVector" -> it.set(readTLIntVector(stream, context))
            "Double" -> it.set(readDouble(stream))
            "TLVector" -> it.set(readTLVector(stream, context))
            "TLLongVector" -> it.set(readTLLongVector(stream, context))
            "TLStringVector" -> it.set(readTLStringVector(stream, context))
            "Byte" -> it.set(readByte(stream))
            "TLBytes" -> it.set(readTLBytes(stream, context))
            "ByteArray" -> it.set(readByteArray(stream))
            "TLObject" -> it.set(readTLObject(stream, context))
        }
    }

    /**
     * Compute the size in bytes of the serialized object
     *
     * @return size in bytes
     */
    open fun computeSerializedSize(): Int {
        return TLObjectUtils.SIZE_CONSTRUCTOR_ID // Constructor is 4-byte (int32)
    }

    /**
     * Throw an exception to notify that the field trying to be serialized is null
     *
     * @param fieldName name of the field trying to be serialized
     * @param flags     flags field current value
     * @throws NullPointerException
     */
    @Throws(NullPointerException::class)
    protected fun throwNullFieldException(fieldName: String, flags: Int) {
        throw NullPointerException("Attempt to serialize null field $fieldName, flags = $flags")
    }
}
