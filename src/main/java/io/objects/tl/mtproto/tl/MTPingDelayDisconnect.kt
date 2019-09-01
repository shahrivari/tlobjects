package io.objects.tl.mtproto.tl

import io.objects.tl.StreamUtils.*
import io.objects.tl.TLContext
import io.objects.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTPingDelayDisconnect @JvmOverloads constructor(var pingId: Long = 0, var disconnectDelay: Int = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(pingId, stream)
        writeInt(disconnectDelay, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        pingId = readLong(stream)
        disconnectDelay = readInt(stream)
    }

    override fun toString(): String {
        return "PingDelayDisconnect#f3427b8c(id=$pingId, delay=$disconnectDelay)"
    }



    companion object {
        const val CONSTRUCTOR_ID = -213746804
    }
}
