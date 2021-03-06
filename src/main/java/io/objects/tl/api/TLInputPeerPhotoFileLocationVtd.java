package io.objects.tl.api;

import io.objects.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLInputPeerPhotoFileLocationVtd extends TLAbsInputFileLocation {
    public static final int CONSTRUCTOR_ID = 0x27d69997;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected long volumeId;

    protected int localId;

    private final String _constructor = "inputPeerPhotoFileLocationVtd#27d69997";

    public TLInputPeerPhotoFileLocationVtd() {

    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeLong(volumeId, stream);
        writeInt(localId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        volumeId = readLong(stream);
        localId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += peer.computeSerializedSize();
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

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLInputPeerUser peer) {
        this.peer = peer;
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
}
