package io.objects.tl.api.request;

import io.objects.tl.TLContext;
import io.objects.tl.api.TLGraceConfig;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static io.objects.tl.StreamUtils.readTLObject;

public class TLRequestGraceGetConfig extends TLMethod<TLGraceConfig> {
    public static final int CONSTRUCTOR_ID = 0xe54321bd;

    private final String _constructor = "grace.getConfig#e54321bd";

    public TLRequestGraceGetConfig() {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLGraceConfig deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLGraceConfig)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLGraceConfig) response;
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