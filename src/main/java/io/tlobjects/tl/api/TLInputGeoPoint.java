package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLInputGeoPoint extends TLAbsInputGeoPoint {
    public static final int CONSTRUCTOR_ID = 0xf3b7acc9;

    protected double lat;

    protected double _long;

    private final String _constructor = "inputGeoPoint#f3b7acc9";

    public TLInputGeoPoint() {
    }

    public TLInputGeoPoint(double lat, double _long) {
        this.lat = lat;
        this._long = _long;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(lat, stream);
        writeDouble(_long, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        lat = readDouble(stream);
        _long = readDouble(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLong() {
        return _long;
    }

    public void setLong(double _long) {
        this._long = _long;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLInputGeoPoint getAsInputGeoPoint() {
        return this;
    }
}
