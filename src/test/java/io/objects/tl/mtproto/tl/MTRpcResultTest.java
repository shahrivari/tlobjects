package io.objects.tl.mtproto.tl;

import io.objects.tl.TLObjectUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MTRpcResultTest {

    @Test
    void SerializeAndDeserialize() throws IOException {
        MTRpcResult result = new MTRpcResult();
        result.setContentLen(5);
        result.setContent(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        result.setMessageId(10);

        byte[] bytes = result.serialize();
        MTRpcResult object = TLObjectUtils.deserialize(bytes);

        assertThat(result.getContentLen()).isEqualTo(object.getContentLen());
        assertThat(result.getContent()).isEqualTo(object.getContent());
        assertThat(result.getMessageId()).isEqualTo(object.getMessageId());
    }
}