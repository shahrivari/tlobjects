package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLTextConcat extends TLAbsRichText {
    public static final int CONSTRUCTOR_ID = 0x7e6260d7;

    protected TLVector<TLAbsRichText> texts;

    private final String _constructor = "textConcat#7e6260d7";

    public TLTextConcat() {
    }

    public TLTextConcat(TLVector<TLAbsRichText> texts) {
        this.texts = texts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(texts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        texts = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += texts.computeSerializedSize();
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

    public TLVector<TLAbsRichText> getTexts() {
        return texts;
    }

    public void setTexts(TLVector<TLAbsRichText> texts) {
        this.texts = texts;
    }
}
