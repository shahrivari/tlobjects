package io.objects.tl.api;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

/**
 * This class is updated by Adel to sync with client
 */
public class TLPeerNotifySettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xaf509d20;
    private final String _constructor = "peerNotifySettings#af509d20";
    protected int flags;
    protected boolean showPreviews;
    protected boolean silent;
    protected Integer muteUntil;
    protected String sound;

    public TLPeerNotifySettings() {
    }

    public TLPeerNotifySettings(boolean showPreviews, boolean silent, Integer muteUntil,
                                String sound) {
        this.showPreviews = showPreviews;
        this.silent = silent;
        this.muteUntil = muteUntil;
        this.sound = sound;
    }

    private void computeFlags() {
        flags = 0;
        flags = showPreviews ? (flags | 1) : (flags & ~1);
        flags = silent ? (flags | 2) : (flags & ~2);
        flags = muteUntil != null ? (flags | 4) : (flags & ~4);
        flags = sound != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            writeBoolean(showPreviews, stream);
        }
        if ((flags & 2) != 0) {
            writeBoolean(silent, stream);
        }
        if ((flags & 4) != 0) {
            if (muteUntil == null) throwNullFieldException("muteUntil", flags);
            writeInt(muteUntil, stream);
        }
        if ((flags & 8) != 0) {
            if (sound == null) throwNullFieldException("sound", flags);
            writeString(sound, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        showPreviews = (flags & 1) != 0 ? readTLBool(stream) : false;
        silent = (flags & 2) != 0 ? readTLBool(stream) : false;
        muteUntil = (flags & 4) != 0 ? readInt(stream) : null;
        sound = (flags & 8) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 2) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 4) != 0) {
            if (muteUntil == null) throwNullFieldException("muteUntil", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (sound == null) throwNullFieldException("sound", flags);
            size += computeTLStringSerializedSize(sound);
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

    public boolean getShowPreviews() {
        return showPreviews;
    }

    public void setShowPreviews(boolean showPreviews) {
        this.showPreviews = showPreviews;
    }

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public Integer getMuteUntil() {
        return muteUntil;
    }

    public void setMuteUntil(Integer muteUntil) {
        this.muteUntil = muteUntil;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
