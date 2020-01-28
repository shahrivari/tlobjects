package io.objects.tl.api;

import io.objects.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLInputPhotoCropAutoVios extends TLAbsInputPhotoCrop {
    public static final int CONSTRUCTOR_ID = 0x987dc5e1;

    private final String _constructor = "inputPhotoCropAutoVios#987dc5e1";

    public TLInputPhotoCropAutoVios() {
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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
}
