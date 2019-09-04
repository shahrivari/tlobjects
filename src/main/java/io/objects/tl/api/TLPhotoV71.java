package io.objects.tl.api;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

/**
 * This class is updated by Adel to sync with client
 */
public class TLPhotoV71 extends TLAbsPhoto {
    public static final int CONSTRUCTOR_ID = 0x9288dd29;
    private final String _constructor = "photoV71#9288dd29";
    protected int flags;
    protected boolean hasStickers;
    protected long accessHash;
    protected int date;
    protected TLVector<TLAbsPhotoSize> sizes;

    private void computeFlags() {
        flags = 0;
        flags = hasStickers ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeTLVector(sizes, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasStickers = (flags & 1) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        sizes = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += sizes.computeSerializedSize();
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

    public boolean getHasStickers() {
        return hasStickers;
    }

    public void setHasStickers(boolean hasStickers) {
        this.hasStickers = hasStickers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLVector<TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(TLVector<TLAbsPhotoSize> sizes) {
        this.sizes = sizes;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    public final TLPhotoV71 getAsPhotoV71() {
        return this;
    }
}
