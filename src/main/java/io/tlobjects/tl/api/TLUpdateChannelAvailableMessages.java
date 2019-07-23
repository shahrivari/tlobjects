package io.tlobjects.tl.api;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLUpdateChannelAvailableMessages extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x70db6837;

    protected int channelId;

    protected int availableMinId;

    private final String _constructor = "updateChannelAvailableMessages#70db6837";

    public TLUpdateChannelAvailableMessages() {
    }

    public TLUpdateChannelAvailableMessages(int channelId, int availableMinId) {
        this.channelId = channelId;
        this.availableMinId = availableMinId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(channelId, stream);
        writeInt(availableMinId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readInt(stream);
        availableMinId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getAvailableMinId() {
        return availableMinId;
    }

    public void setAvailableMinId(int availableMinId) {
        this.availableMinId = availableMinId;
    }
}
