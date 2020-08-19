package io.objects.tl.core

import io.objects.tl.StreamUtils
import io.objects.tl.StreamUtils.readInt
import io.objects.tl.StreamUtils.readTLString
import io.objects.tl.TLContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class TLTest : TLObject {
    var name: String = ""
    var age: Int = 0
    var avg: Int? = null

    constructor()

    constructor(name: String, age: Int, avg: Int?) {
        this.name = name
        this.age = age
        this.avg = avg
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        builder = TLBuilder.generateSerializer()
                .withProperty(::name)
                .withProperty(::age)
                .withProperty(::avg)
                .build()
    }

    override fun deserializeBody(stream: InputStream, context: TLContext) {
        builder = TLBuilder.generateSerializer()
                .withProperty(::name)
                .withProperty(::age)
                .withProperty(::avg)
                .build()
        super.deserializeBody(stream, context)
    }

    override fun getConstructorId(): Int {
        return 0xe2d75024.toInt()
    }
}
