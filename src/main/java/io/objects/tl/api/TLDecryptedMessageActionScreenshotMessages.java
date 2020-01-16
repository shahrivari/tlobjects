package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLLongVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLDecryptedMessageActionScreenshotMessages extends TLAbsDecryptedMessageAction {
    public static final int CONSTRUCTOR_ID = 0x8ac1f475;

    protected TLLongVector randomIds;

    private final String _constructor = "decryptedMessageActionScreenshotMessages#8ac1f475";

    public TLDecryptedMessageActionScreenshotMessages() {
    }

    public TLDecryptedMessageActionScreenshotMessages(TLLongVector randomIds) {
        this.randomIds = randomIds;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(randomIds, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        randomIds = readTLLongVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += randomIds.computeSerializedSize();
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

    public TLLongVector getRandomIds() {
        return randomIds;
    }

    public void setRandomIds(TLLongVector randomIds) {
        this.randomIds = randomIds;
    }
}
