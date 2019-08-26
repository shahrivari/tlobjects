package io.objects.tl.api;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.SIZE_INT32;
import static io.objects.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLChannelOwnerTransferRequest extends TLMethod<TLChannelOwnerRegistered> {
    public static final int CONSTRUCTOR_ID = 0x87272bc7;

    private int flags;

    private boolean migrateData;

    private String phoneNumber;

    public TLChannelOwnerTransferRequest() {

    }

    public TLChannelOwnerTransferRequest(String phoneNumber, boolean migrateData) {
        setPhoneNumber(phoneNumber);
        setMigrateData(migrateData);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLChannelOwnerRegistered deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }

        if (!(response instanceof TLAbsUser)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }

        return (TLChannelOwnerRegistered) response;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isMigrateData() {
        return migrateData;
    }

    public void setMigrateData(boolean migrateData) {
        this.migrateData = migrateData;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public String toString() {
        return "channelOwnerTransferRequest#0x87272bc7";
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(phoneNumber, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        migrateData = (flags & 1) != 0;

        phoneNumber = readTLString(stream);
    }

    private void computeFlags(){
        flags = 0;
        flags = migrateData ? (flags | 1) : (flags & ~1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(phoneNumber);
        return size;
    }
}
