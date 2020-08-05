package io.objects.tl.core

import java.io.IOException
import java.io.OutputStream

class TLTest : TLObject {
    var name: String = ""
    var age: Int = 0
    var avg: Int? = null

    constructor() {}

    constructor(name: String, age: Int, flag: Int?) {
        this.name = name
        this.age = age
        this.avg = flag
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        val builder = TLBuilder()
                .withProperty(::name)
                .withProperty(::age)
                .withProperty(::avg)
                .build()
    }

    override fun getConstructorId(): Int {
        return -0x1d28afdc
    }
}
