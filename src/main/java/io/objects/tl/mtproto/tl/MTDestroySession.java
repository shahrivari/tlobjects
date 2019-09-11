package io.objects.tl.mtproto.tl;

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
 * This class is updated by MOHoLiaghat: V85a
 */
public class MTDestroySession extends TLMethod<MTAbsDestroySessionResponse> {
    public static final int CONSTRUCTOR_ID = 0xe7512126;

    public MTDestroySession() {
    }

    public void serializeBody(OutputStream stream) throws IOException {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        return size;
    }


    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public MTAbsDestroySessionResponse deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof MTAbsDestroySessionResponse)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (MTAbsDestroySessionResponse) response;
    }
}
