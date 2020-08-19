package io.objects.tl.core

import io.objects.tl.TLObjectUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import java.io.IOException

import org.junit.jupiter.api.Assertions.*

internal class TLTestTest {

    @Test
    @Throws(IOException::class)
    fun test_serialize() {
        val test = TLTest("ali", 26, 1012)
        val bytes = test.serialize()
        val deserialize = TLObjectUtils.deserialize<TLTest>(bytes)

        println("****")
        with(deserialize){
            println(name)
            println(age)
            println(avg)

            assertThat(name).isEqualTo(test.name)
            assertThat(age).isEqualTo(test.age)
            assertThat(avg).isEqualTo(test.avg)

        }
    }
}