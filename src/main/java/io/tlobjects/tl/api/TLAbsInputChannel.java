package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputChannel}: inputChannel#afeb712e</li>
 * <li>{@link TLInputChannelEmpty}: inputChannelEmpty#ee8c1e86</li>
 * </ul>
 *
 * This class is generated by Mono's TL class generator
 */
public abstract class TLAbsInputChannel extends TLObject {
    public TLAbsInputChannel() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputChannel getAsInputChannel() {
        return null;
    }

    public static TLInputChannelEmpty newEmpty() {
        return new TLInputChannelEmpty();
    }

    public static TLInputChannel newNotEmpty() {
        return new TLInputChannel();
    }
}
