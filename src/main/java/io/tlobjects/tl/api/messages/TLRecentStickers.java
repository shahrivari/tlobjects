package io.tlobjects.tl.api.messages;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLAbsDocument;
import io.tlobjects.tl.api.TLStickerPack;
import io.tlobjects.tl.core.TLIntVector;
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
public class TLRecentStickers extends TLAbsRecentStickers {
    public static final int CONSTRUCTOR_ID = 0x22f3afb3;

    protected int hash;

    protected TLVector<TLStickerPack> packs;

    protected TLVector<TLAbsDocument> stickers;

    protected TLIntVector dates;

    private final String _constructor = "messages.recentStickers#22f3afb3";

    public TLRecentStickers() {
    }

    public TLRecentStickers(int hash, TLVector<TLStickerPack> packs,
            TLVector<TLAbsDocument> stickers, TLIntVector dates) {
        this.hash = hash;
        this.packs = packs;
        this.stickers = stickers;
        this.dates = dates;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(packs, stream);
        writeTLVector(stickers, stream);
        writeTLVector(dates, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        packs = readTLVector(stream, context);
        stickers = readTLVector(stream, context);
        dates = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += packs.computeSerializedSize();
        size += stickers.computeSerializedSize();
        size += dates.computeSerializedSize();
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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<TLStickerPack> getPacks() {
        return packs;
    }

    public void setPacks(TLVector<TLStickerPack> packs) {
        this.packs = packs;
    }

    public TLVector<TLAbsDocument> getStickers() {
        return stickers;
    }

    public void setStickers(TLVector<TLAbsDocument> stickers) {
        this.stickers = stickers;
    }

    public TLIntVector getDates() {
        return dates;
    }

    public void setDates(TLIntVector dates) {
        this.dates = dates;
    }
}
