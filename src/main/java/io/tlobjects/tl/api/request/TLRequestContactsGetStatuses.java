package io.tlobjects.tl.api.request;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLContactStatus;
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
public class TLRequestContactsGetStatuses extends TLMethod<TLVector<TLContactStatus>> {
    public static final int CONSTRUCTOR_ID = 0xc4a353ee;

    private final String _constructor = "contacts.getStatuses#c4a353ee";

    public TLRequestContactsGetStatuses() {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLContactStatus> deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
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
