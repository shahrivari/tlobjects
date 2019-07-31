package io.objects.tl.api;

import io.objects.tl.TLObjectUtils;
import io.objects.tl.api.request.TLRequestChannelsCreateChannel;
import io.objects.tl.core.TLVector;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.SecureRandom;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TLReqResLogTest {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }

        return builder.toString();
    }

    @Test
    void testTLReqResLogSerializationDeSerialization() throws IOException {
        TLReqResLog log = new TLReqResLog();
        SecureRandom random = new SecureRandom();
        log.setAuthKeyId(Math.abs(random.nextLong()) + 1);
        log.setUserId(random.nextInt());
        log.setRequestTime(random.nextInt());
        log.setResponseTime(random.nextInt());

        TLRequestChannelsCreateChannel request = new TLRequestChannelsCreateChannel();
        request.setTitle(randomAlphaNumeric(10));
        request.setAbout(randomAlphaNumeric(200));
        request.setBroadcast(true);
        request.setMegagroup(true);
        log.setRequest(request);

        log.setResponse(new TLUpdateChannel());
        log.setUpdates(new TLUpdates(new TLVector(), new TLVector(), new TLVector(), 0, 5));

        byte[] bytes = log.serialize();
        TLReqResLog deserialize = TLObjectUtils.deserialize(bytes);

        assertThat(log.authKeyId).isEqualTo(deserialize.authKeyId);
        assertThat(log.userId).isEqualTo(deserialize.userId);
        assertThat(log.requestTime).isEqualTo(deserialize.requestTime);
    }
}