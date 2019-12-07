package io.objects.tl.api;

import io.objects.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

/**
 * This class is generated by Alxan and Xanjar: V85a
 */
public class TLFileLocationVtd extends TLAbsFileLocation {
    public static final int CONSTRUCTOR_ID = 0xbc7fc6cd;

    protected int dcId;

    private final String _constructor = "fileLocationVtd#bc7fc6cd";

    public TLFileLocationVtd() {
    }

    public TLFileLocationVtd(int dcId, long volumeId, int localId, long secret) {
        this.dcId = dcId;
        this.volumeId = volumeId;
        this.localId = localId;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(volumeId, stream);
        writeInt(localId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        volumeId = readLong(stream);
        localId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(long volumeId) {
        this.volumeId = volumeId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long secret) {
        this.secret = secret;
    }

}
