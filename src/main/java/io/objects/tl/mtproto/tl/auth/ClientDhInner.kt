package io.objects.tl.mtproto.tl.auth

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ClientDhInner @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0), var serverNonce: ByteArray = ByteArray(0),
                                              var retryId: Long = 0, var gb: ByteArray = ByteArray(0)) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeByteArray(nonce, stream)
        writeByteArray(serverNonce, stream)
        writeLong(retryId, stream)
        writeTLBytes(gb, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        retryId = readLong(stream)
        gb = readTLBytes(stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1715713620
    }
}
