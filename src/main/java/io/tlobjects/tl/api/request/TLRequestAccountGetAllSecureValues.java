package io.tlobjects.tl.api.request;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLSecureValue;
import io.tlobjects.tl.core.TLMethod;
import io.tlobjects.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLRequestAccountGetAllSecureValues extends TLMethod<TLVector<TLSecureValue>> {
    public static final int CONSTRUCTOR_ID = 0xb288bc7d;

    private final String _constructor = "account.getAllSecureValues#b288bc7d";

    public TLRequestAccountGetAllSecureValues() {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLSecureValue> deserializeResponse(InputStream stream, TLContext context) throws
            IOException {
        return readTLVector(stream, context);
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
