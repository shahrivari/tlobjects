package io.objects.tl.mtproto.tl.auth

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.core.TLMethod
import io.objects.tl.exception.DeserializationException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ReqSetDhClientParams @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                                     var serverNonce: ByteArray = ByteArray(0),
                                                     var encrypted: ByteArray = ByteArray(0)) : TLMethod<DhGenResult>() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeByteArray(nonce, stream)
        writeByteArray(serverNonce, stream)
        writeTLBytes(encrypted, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        encrypted = readTLBytes(stream)
    }

    @Throws(IOException::class)
    override fun deserializeResponse(stream: InputStream, context: TLContext): DhGenResult {
        val response = context.deserializeMessage(stream) ?: throw DeserializationException("Unable to deserialize response")
        if (response !is DhGenResult) {
            throw DeserializationException("Response has incorrect type")
        }
        return response
    }

    override fun toString(): String {
        return "set_client_DH_params#f5045f1f"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -184262881
    }
}