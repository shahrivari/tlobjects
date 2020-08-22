package io.objects.tl.core

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.TLObjectUtils
import io.objects.tl.exception.InvalidConstructorIdException
import java.io.*

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
            it.list.forEach {
                with(it) {
                    println("$name ${get()}")
                }
            }

            it.list.forEach {
                val value = it.get()
                val name = it.name
                var type = it.returnType.toString().split(".").last()
                val last = type.toCharArray().last().toString()
                val isNullable = last == "?"
                if (last == "?") type = type.substring(0, type.lastIndex)

                when {
                    type.contentEquals("String") -> writeString(value as String, stream)
                    type.contentEquals("Int") -> writeInt(value as Int, stream)
                    type.contentEquals("Boolean") -> writeBoolean(value as Boolean, stream)
                    type.contentEquals("TLIntVector") -> writeTLVector(value as TLIntVector, stream)
                    type.contentEquals("Double") -> writeDouble(value as Double, stream)
                    type.contentEquals("TLVector") -> writeTLVector(value as TLVector<*>, stream)
                }
//                    println("$name == $value == $type == $last == $isNullable \n")
            }
        }
    }

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
        println("=================================")
        builder?.let {
            it.list.forEach {
                var type = it.returnType.toString().split(".").last()
                val last = type.toCharArray().last().toString()
                val isNullable = last == "?"
                if (last == "?") type = type.substring(0, type.lastIndex)

                when {
                    type.contentEquals("String") -> it.set(readTLString(stream))
                    type.contentEquals("Int") -> it.set(readInt(stream))
                    type.contentEquals("Boolean") -> it.set(readTLBool(stream))
                    type.contentEquals("TLIntVector") -> it.set(readTLIntVector(stream, context))
                    type.contentEquals("Double") -> it.set(readDouble(stream))
                    type.contentEquals("TLVector") -> it.set(readTLVector(stream, context))
                }

                    // println("${it.name}  $type == $last == $isNullable \n")
            }
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
