package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLPrivacyValueDisallowAll extends TLAbsPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0x8b73e763;

    private final String _constructor = "privacyValueDisallowAll#8b73e763";

    public TLPrivacyValueDisallowAll() {
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
