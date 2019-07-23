package io.tlobjects.tl.api.storage;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLFileJpeg extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0x7efe0e;

    private final String _constructor = "storage.fileJpeg#7efe0e";

    public TLFileJpeg() {
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
