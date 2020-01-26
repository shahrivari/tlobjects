package io.objects.tl.api.request;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLBool;
import io.objects.tl.core.TLIntVector;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

public class TLRequestAccountRegisterDeviceVios extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x1389cc;

    private final String _constructor = "account.registerDeviceVios#1389cc";

    protected int tokenType;

    protected String token;

    protected boolean appSandbox;

    protected TLIntVector otherUids;

    public TLRequestAccountRegisterDeviceVios() {

    }

    public TLRequestAccountRegisterDeviceVios(int tokenType, String token, boolean appSandbox, TLIntVector otherUids) {
        this.tokenType = tokenType;
        this.token = token;
        this.appSandbox = appSandbox;
        this.otherUids = otherUids;
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
        writeInt(tokenType, stream);
        writeString(token, stream);
        writeBoolean(appSandbox, stream);
        writeTLVector(otherUids, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        tokenType = readInt(stream);
        token = readTLString(stream);
        appSandbox = readTLBool(stream);
        otherUids = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(token);
        size += SIZE_BOOLEAN;
        size += otherUids.computeSerializedSize();
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

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean getAppSandbox() {
        return appSandbox;
    }

    public void setAppSandbox(boolean appSandbox) {
        this.appSandbox = appSandbox;
    }

    public TLIntVector getOtherUids() {
        return otherUids;
    }

    public void setOtherUids(TLIntVector otherUids) {
        this.otherUids = otherUids;
    }
}
