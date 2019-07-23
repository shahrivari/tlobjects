package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLPrivacyKeyChatInvite extends TLAbsPrivacyKey {
    public static final int CONSTRUCTOR_ID = 0x500e6dfa;

    private final String _constructor = "privacyKeyChatInvite#500e6dfa";

    public TLPrivacyKeyChatInvite() {
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
