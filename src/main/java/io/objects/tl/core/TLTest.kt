package io.objects.tl.core

import io.objects.tl.TLContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class TLTest : TLObject {
    var name: String = ""
    var age: Int = 0
    var avg: Int? = null
    var list: TLVector<TLBool>? = null
    var a: Boolean = false
    var b: Double = 0.0

    constructor()

    constructor(name: String, age: Int, avg: Int?, list: TLVector<TLBool>, a: Boolean, b: Double) {
        this.name = name
        this.age = age
        this.avg = avg
        this.list = list
        this.a = a
        this.b = b
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        builder = TLBuilder.generateSerializer()
                .withProperty(::name)
                .withProperty(::age)
                .withProperty(::avg)
                .withProperty(::list)
                .withProperty(::a)
                .withProperty(::b)
                .build()
    }

    override fun deserializeBody(stream: InputStream, context: TLContext) {
        builder = TLBuilder.generateSerializer()
                .withProperty(::name)
                .withProperty(::age)
                .withProperty(::avg)
                .withProperty(::list)
                .withProperty(::a)
                .withProperty(::b)
                .build()
        super.deserializeBody(stream, context)
    }

    override fun getConstructorId(): Int {
        return 0xe2d75024.toInt()
    }
}
