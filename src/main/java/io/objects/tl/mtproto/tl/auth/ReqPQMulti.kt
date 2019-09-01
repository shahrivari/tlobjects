package io.objects.tl.mtproto.tl.auth

import io.objects.tl.StreamUtils.readBytes
import io.objects.tl.StreamUtils.writeByteArray
import io.objects.tl.TLContext
import io.objects.tl.core.TLMethod
import io.objects.tl.exception.DeserializationException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ReqPQMulti constructor(nonce: ByteArray? = null) : TLMethod<ResPQ>() {

    var nonce: ByteArray = ByteArray(0)
/*
        set(nonce) {
            if (nonce.size != 16) {
                throw IllegalArgumentException("nonce might be not null and 16 bytes length")
            }
            field = nonce
        }

    init {
        if (nonce?.size ?: 0 != 16)
            throw IllegalArgumentException("nonce might be not null and 16 bytes length")
        this.nonce = nonce!!
    }
*/

    @Throws(IOException::class)
    override fun deserializeResponse(stream: InputStream, context: TLContext): ResPQ {
        val response = context.deserializeMessage(stream) ?: throw DeserializationException("Unable to deserialize response")
        if (response !is ResPQ) {
            throw DeserializationException("Response has incorrect type")
        }

        return response
    }

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeByteArray(nonce, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
    }

    override fun toString(): String {
        return "req_pq#60469778"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1099002127
    }
}
