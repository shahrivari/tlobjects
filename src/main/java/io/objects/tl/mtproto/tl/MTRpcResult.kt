package io.objects.tl.mtproto.tl

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTRpcResult @JvmOverloads constructor(var messageId: Long = 0,
                                            var content: ByteArray = ByteArray(0),
                                            var contentLen: Int = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(messageId, stream)
        writeByteArray(content, 0, contentLen, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messageId = readLong(stream)
        contentLen = stream.available()
        content = ByteArray(contentLen)
        readBytes(content, 0, contentLen, stream)
    }

    override fun toString(): String {
        return "rpc_result#f35c6d01"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -212046591

        fun createFrom(msgId: Long, obj: TLObject): MTRpcResult {
            val rpcResult = MTRpcResult()
            rpcResult.messageId = msgId
            rpcResult.content = obj.serialize()
            rpcResult.contentLen = rpcResult.content.size
            return rpcResult
        }
    }
}