package io.tlobjects.tl.api.storage;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLFileMp4 extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0xb3cea0e4;

    private final String _constructor = "storage.fileMp4#b3cea0e4";

    public TLFileMp4() {
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
