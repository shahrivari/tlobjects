package io.tlobjects.tl.api.request;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.help.TLInviteText;
import io.tlobjects.tl.core.TLMethod;
import io.tlobjects.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLRequestHelpGetInviteText extends TLMethod<TLInviteText> {
    public static final int CONSTRUCTOR_ID = 0x4d392343;

    private final String _constructor = "help.getInviteText#4d392343";

    public TLRequestHelpGetInviteText() {
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLInviteText deserializeResponse(InputStream stream, TLContext context) throws
            IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLInviteText)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLInviteText) response;
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
