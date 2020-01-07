package io.objects.tl.api;

import io.objects.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLChannelAdminRightsNull extends TLAbsChannelAdminRights {
    public static final int CONSTRUCTOR_ID = 0x56730bcc;

    private final String _constructor = "null#56730bcc";

    public TLChannelAdminRightsNull() {
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