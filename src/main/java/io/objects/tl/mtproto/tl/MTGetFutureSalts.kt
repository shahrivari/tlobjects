package io.objects.tl.mtproto.tl

import io.objects.tl.StreamUtils.readInt
import io.objects.tl.StreamUtils.writeInt
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTGetFutureSalts @JvmOverloads constructor(var num: Int = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeInt(num, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        num = readInt(stream)
    }

    override fun toString(): String {
        return "get_future_salts#b921bd04"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1188971260
    }
}
