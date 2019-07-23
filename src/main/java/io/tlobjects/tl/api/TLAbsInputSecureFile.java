package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputSecureFile}: inputSecureFile#5367e5be</li>
 * <li>{@link TLInputSecureFileUploaded}: inputSecureFileUploaded#3334b0f0</li>
 * </ul>
 *
 * This class is generated by Mono's TL class generator
 */
public abstract class TLAbsInputSecureFile extends TLObject {
    protected long id;

    public TLAbsInputSecureFile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
