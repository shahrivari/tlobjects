package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLInputMessagesFilterChatPhotos extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x3a20ecb8;

    private final String _constructor = "inputMessagesFilterChatPhotos#3a20ecb8";

    public TLInputMessagesFilterChatPhotos() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
