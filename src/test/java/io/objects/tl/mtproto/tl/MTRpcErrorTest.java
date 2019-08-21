package io.objects.tl.mtproto.tl;

import io.objects.tl.TLObjectUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MTRpcErrorTest {
    @Test
    void SerializeAndDeserialize() throws IOException {
        MTRpcError result = new MTRpcError();
        result.setErrorCode(401);
        result.setMessage("test message");

        byte[] bytes = result.serialize();
        MTRpcError object = TLObjectUtils.deserialize(bytes);

        assertThat(result.getMessage()).isEqualTo(object.getMessage());
        assertThat(result.getErrorCode()).isEqualTo(object.getErrorCode());
    }
}