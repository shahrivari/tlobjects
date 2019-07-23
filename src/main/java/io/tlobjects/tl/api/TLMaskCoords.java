package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLMaskCoords extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xaed6dbb2;

    protected int n;

    protected double x;

    protected double y;

    protected double zoom;

    private final String _constructor = "maskCoords#aed6dbb2";

    public TLMaskCoords() {
    }

    public TLMaskCoords(int n, double x, double y, double zoom) {
        this.n = n;
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(n, stream);
        writeDouble(x, stream);
        writeDouble(y, stream);
        writeDouble(zoom, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        n = readInt(stream);
        x = readDouble(stream);
        y = readDouble(stream);
        zoom = readDouble(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_DOUBLE;
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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
}
