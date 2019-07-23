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
public class TLUpdatePinnedDialogs extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xea4cb65b;

    protected int flags;

    protected TLVector<TLDialogPeer> order;

    private final String _constructor = "updatePinnedDialogs#ea4cb65b";

    public TLUpdatePinnedDialogs() {
    }

    public TLUpdatePinnedDialogs(TLVector<TLDialogPeer> order) {
        this.order = order;
    }

    private void computeFlags() {
        flags = 0;
        flags = order != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (order == null) throwNullFieldException("order", flags);
            writeTLVector(order, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        order = (flags & 1) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (order == null) throwNullFieldException("order", flags);
            size += order.computeSerializedSize();
        }
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

    public TLVector<TLDialogPeer> getOrder() {
        return order;
    }

    public void setOrder(TLVector<TLDialogPeer> order) {
        this.order = order;
    }
}
