package io.objects.tl.api.help;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.readTLObject;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.SIZE_INT32;

/**
 * This class is updated by Adel to sync with client
 */
public class TLRequestHelpGetTermsOfServiceUpdate extends TLMethod<TLAbsTermsOfServiceUpdate> {
    public static final int CONSTRUCTOR_ID = 0x2ca51fd1;

    private final String _constructor = "help.getTermsOfServiceUpdate#2ca51fd1";

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
    }

    @Override
    public TLAbsTermsOfServiceUpdate deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsTermsOfServiceUpdate)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsTermsOfServiceUpdate) response;
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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
