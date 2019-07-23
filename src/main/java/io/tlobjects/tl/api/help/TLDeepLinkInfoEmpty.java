package io.tlobjects.tl.api.help;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLDeepLinkInfoEmpty extends TLAbsDeepLinkInfo {
    public static final int CONSTRUCTOR_ID = 0x66afa166;

    private final String _constructor = "help.deepLinkInfoEmpty#66afa166";

    public TLDeepLinkInfoEmpty() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
