package io.objects.tl.core;

import io.objects.tl.TLObjectUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TLTestTest {

    @Test
    void test_serialize() throws IOException {
        TLTest test = new TLTest("ali" , 26 , 1012);
        byte[] bytes = test.serialize();
        TLTest deserialize = TLObjectUtils.deserialize(bytes);

        System.out.println("****");
        System.out.println(deserialize.getName());
    }
}