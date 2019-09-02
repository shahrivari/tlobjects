/*
package io.objects.tl.mtproto.tl

import io.objects.tl.TLObjectUtils
import org.junit.jupiter.api.Test

import java.io.IOException

import org.assertj.core.api.Java6Assertions.assertThat

internal class MTRpcResultTest {

    @Test
    fun SerializeAndDeserialize() {
        val result = MTRpcResult()
        result.contentLen = 5
        result.content = byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        result.messageId = 10

        val bytes = result.serialize()
        val `object` = TLObjectUtils.deserialize<MTRpcResult>(bytes)

        assertThat(result.contentLen).isEqualTo(`object`.contentLen)
        assertThat(result.content).isEqualTo(`object`.content)
        assertThat(result.messageId).isEqualTo(`object`.messageId)
    }
}*/
