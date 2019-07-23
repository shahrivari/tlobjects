package io.tlobjects.tl.api.request;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLAbsInputPeer;
import io.tlobjects.tl.api.TLAbsReportReason;
import io.tlobjects.tl.core.TLBool;
import io.tlobjects.tl.core.TLMethod;
import io.tlobjects.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLRequestAccountReportPeer extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0xae189d5f;

    protected TLAbsInputPeer peer;

    protected TLAbsReportReason reason;

    private final String _constructor = "account.reportPeer#ae189d5f";

    public TLRequestAccountReportPeer() {
    }

    public TLRequestAccountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) {
        this.peer = peer;
        this.reason = reason;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(reason, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        reason = readTLObject(stream, context, TLAbsReportReason.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += reason.computeSerializedSize();
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsReportReason getReason() {
        return reason;
    }

    public void setReason(TLAbsReportReason reason) {
        this.reason = reason;
    }
}
