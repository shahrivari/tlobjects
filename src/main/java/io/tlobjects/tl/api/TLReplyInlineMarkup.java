package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLReplyInlineMarkup extends TLAbsReplyMarkup {
    public static final int CONSTRUCTOR_ID = 0x48a30254;

    protected TLVector<TLKeyboardButtonRow> rows;

    private final String _constructor = "replyInlineMarkup#48a30254";

    public TLReplyInlineMarkup() {
    }

    public TLReplyInlineMarkup(TLVector<TLKeyboardButtonRow> rows) {
        this.rows = rows;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(rows, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        rows = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += rows.computeSerializedSize();
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

    public TLVector<TLKeyboardButtonRow> getRows() {
        return rows;
    }

    public void setRows(TLVector<TLKeyboardButtonRow> rows) {
        this.rows = rows;
    }
}
