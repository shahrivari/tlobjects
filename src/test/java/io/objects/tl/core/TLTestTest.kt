package io.objects.tl.core

import io.objects.tl.TLObjectUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.IOException

internal class TLTestTest {

    @Test
    @Throws(IOException::class)
    fun test_serialize() {
//        val list = TLIntVector().apply { addAll(listOf(5, 7, 8, 9)) }

        val list = TLVector<TLBool>().apply {
            this.addAll(listOf(TLBool.TRUE , TLBool.FALSE , TLBool.TRUE))
        }
        val test = TLTest("ali", 26, null, list, true, 12.5)
        val bytes = test.serialize()
        val deserialize = TLObjectUtils.deserialize<TLTest>(bytes)

        println("****")
        with(deserialize) {
            assertThat(name).isEqualTo(test.name)
            assertThat(age).isEqualTo(test.age)
            assertThat(avg).isEqualTo(test.avg)
            list.forEachIndexed { index, i -> assertThat(i).isEqualTo(test.list?.get(index)) }
            assertThat(a).isEqualTo(test.a)
            assertThat(b).isEqualTo(test.b)
        }
    }
}