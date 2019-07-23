package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLGeoPoint}: geoPoint#296f104</li>
 * <li>{@link TLGeoPointEmpty}: geoPointEmpty#1117dd5f</li>
 * </ul>
 *
 * This class is generated by Mono's TL class generator
 */
public abstract class TLAbsGeoPoint extends TLObject {
    public TLAbsGeoPoint() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLGeoPoint getAsGeoPoint() {
        return null;
    }
}
