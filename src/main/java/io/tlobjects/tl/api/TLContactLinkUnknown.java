package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLContactLinkUnknown extends TLAbsContactLink {
    public static final int CONSTRUCTOR_ID = 0x5f4f9247;

    private final String _constructor = "contactLinkUnknown#5f4f9247";

    public TLContactLinkUnknown() {
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
