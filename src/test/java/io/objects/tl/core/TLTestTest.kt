package io.objects.tl.core

import io.objects.tl.TLObjectUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.IOException

internal class TLTestTest {

    @Test
    @Throws(IOException::class)
    fun test_serialize() {
        val ints = TLIntVector().apply { addAll(listOf(5, 7, 8, 9)) }

        val tlVector = TLVector<TLBool>().apply {
            addAll(listOf(TLBool.TRUE, TLBool.FALSE, TLBool.TRUE))
        }

        val tlStringVector = TLStringVector().apply {
            add("haji")
            add("ali")
        }

        val tlLongVector = TLLongVector().apply {
            add(12)
            add(13)
            add(14)
        }

        val test =
                TLTest("hasan", 26, null, tlVector, true, 12.5, ints, tlStringVector,
                       1.toByte(),
                       tlLongVector,
                       null)  // ToDo MoHoLiaghat: byteArray kar nemikone

        val bytes = test.serialize()
        val deserialize = TLObjectUtils.deserialize<TLTest>(bytes)

        println("****")
        with(deserialize) {
            assertThat(a).isEqualTo(test.a)
            assertThat(b).isEqualTo(test.b)
            assertThat(c).isEqualTo(test.c)
            deserialize.d?.forEachIndexed { index, i ->
                assertThat(i).isEqualTo(test.d?.get(index))
            }
            assertThat(e).isEqualTo(test.e)
            assertThat(f).isEqualTo(test.f)
            assertThat(g).isEqualTo(test.g)
            assertThat(h).isEqualTo(test.h)
            assertThat(i).isEqualTo(test.i)
            assertThat(j).isEqualTo(test.j)
            assertThat(k).isEqualTo(test.k)
        }
    }
}