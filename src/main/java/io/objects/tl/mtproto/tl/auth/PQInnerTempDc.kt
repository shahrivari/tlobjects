package io.objects.tl.mtproto.tl.auth

import io.objects.tl.StreamUtils.readInt
import io.objects.tl.StreamUtils.writeInt
import io.objects.tl.TLContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class PQInnerTempDc @JvmOverloads constructor(pq: ByteArray = ByteArray(0),
                                              p: ByteArray = ByteArray(0),
                                              q: ByteArray = ByteArray(0),
                                              nonce: ByteArray = ByteArray(0),
                                              serverNonce: ByteArray = ByteArray(0),
                                              newNonce: ByteArray = ByteArray(0),
                                              dc: Int = 1,
                                              var expiresIn: Int = 0) :
        PQInnerDc(pq, p, q, nonce, serverNonce, newNonce, dc) {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        super.serializeBody(stream)
        writeInt(expiresIn, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        super.deserializeBody(stream, context)
        expiresIn = readInt(stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1459478408
    }
}
