package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLInputStickeredMediaDocument extends TLAbsInputStickeredMedia {
    public static final int CONSTRUCTOR_ID = 0x438865b;

    protected TLAbsInputDocument id;

    private final String _constructor = "inputStickeredMediaDocument#438865b";

    public TLInputStickeredMediaDocument() {
    }

    public TLInputStickeredMediaDocument(TLAbsInputDocument id) {
        this.id = id;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLObject(stream, context, TLAbsInputDocument.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += id.computeSerializedSize();
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

    public TLAbsInputDocument getId() {
        return id;
    }

    public void setId(TLAbsInputDocument id) {
        this.id = id;
    }
}
