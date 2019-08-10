package io.objects.tl.api;

import io.objects.tl.TLObjectUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TLChannelOwnerTransferRequestSerializationTest {

    @Test
    public void shouldSerializeAndDeserializeTLChannelOwnerTransferRequestCorrectly() throws IOException {
        String phoneNumber = "01234564789";
        TLChannelOwnerTransferRequest request = new TLChannelOwnerTransferRequest(phoneNumber, true);
        byte[] bytes = request.serialize();

        TLChannelOwnerTransferRequest transferRequest = TLObjectUtils.deserialize(bytes);

        assertThat(transferRequest.getPhoneNumber()).isEqualTo(request.getPhoneNumber());
        assertThat(transferRequest.isMigrateData()).isEqualTo(request.isMigrateData());
    }
}
