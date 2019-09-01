package io.objects.tl.mtproto.tl

import io.objects.tl.StreamUtils.writeByteArray
import io.objects.tl.StreamUtils.writeLong
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTInvokeAfter(var dependMsgId: Long = 0, var request: ByteArray = ByteArray(0)) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(dependMsgId, stream)
        writeByteArray(request, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        throw UnsupportedOperationException("Unable to deserialize invokeAfterMsg#cb9f372d")
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -878758099
    }
}
