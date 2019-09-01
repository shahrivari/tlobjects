package io.objects.tl.mtproto.tl

import io.objects.tl.StreamUtils.readLong
import io.objects.tl.StreamUtils.writeLong
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTPing @JvmOverloads constructor(var pingId: Long = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(pingId, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        pingId = readLong(stream)
    }

    override fun toString(): String {
        return "ping#7abe77ec"
    }

    companion object {
        const val CONSTRUCTOR_ID = 2059302892
    }
}
