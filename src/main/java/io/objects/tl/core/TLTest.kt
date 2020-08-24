package io.objects.tl.core

import io.objects.tl.TLContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class TLTest : TLObject {
    var a: String? = ""
    var b: Int? = 0
    var c: Int? = null
    var d: TLVector<TLBool>? = null
    var e: Boolean = false
    var f: Double = 0.0
    var g: TLIntVector? = null
    var h: TLStringVector? = null
    var i: Byte? = null
    var j: TLLongVector = TLLongVector()
    var k: ByteArray? = null

    constructor()

    constructor(a: String?,
                b: Int?,
                c: Int?,
                d: TLVector<TLBool>?,
                e: Boolean,
                f: Double,
                g: TLIntVector?,
                h: TLStringVector?,
                i: Byte?,
                j: TLLongVector,
                k: ByteArray?) {
        this.a = a
        this.b = b
        this.c = c
        this.d = d
        this.e = e
        this.f = f
        this.g = g
        this.h = h
        this.i = i
        this.j = j
        this.k = k
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        builder = TLBuilder.generateSerializer()
                .withProperty(::a)
                .withProperty(::b)
                .withProperty(::c)
                .withProperty(::d)
                .withProperty(::e)
                .withProperty(::f)
                .withProperty(::g)
                .withProperty(::h)
                .withProperty(::i)
                .withProperty(::j)
                .withProperty(::k)
                .build()
    }

    override fun deserializeBody(stream: InputStream, context: TLContext) {
        builder = TLBuilder.generateSerializer()
                .withProperty(::a)
                .withProperty(::b)
                .withProperty(::c)
                .withProperty(::d)
                .withProperty(::e)
                .withProperty(::f)
                .withProperty(::g)
                .withProperty(::h)
                .withProperty(::i)
                .withProperty(::j)
                .withProperty(::k)
                .build()
        super.deserializeBody(stream, context)
    }

    override fun getConstructorId(): Int {
        return 0xe2d75024.toInt()
    }
}
