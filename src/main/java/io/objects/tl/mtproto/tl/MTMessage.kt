package io.objects.tl.mtproto.tl

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import io.objects.tl.StreamUtils.writeLong
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTMessage @JvmOverloads constructor(var messageId: Long = 0,
                                          var seqNo: Int = 0,
                                          var payload: ByteArray = ByteArray(0),
                                          var payloadLength: Int = payload.size,
                                          var sessionIdBytes: ByteArray = ByteArray(0)) :
        TLObject() {

    override fun getConstructorId(): Int {
        return 0
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(messageId, stream)
        writeInt(seqNo, stream)
        writeInt(payloadLength, stream)
        writeByteArray(payload, 0, payloadLength, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messageId = readLong(stream)
        seqNo = readInt(stream)
        payloadLength = readInt(stream)
        payload = ByteArray(payloadLength)
        readBytes(payload, 0, payloadLength, stream)
    }

    override fun toString(): String {
        return "MTMessage: {id: $messageId, seqNo: $seqNo}"
    }

    companion object {
        const val CONSTRUCTOR_ID = 0
    }
}
