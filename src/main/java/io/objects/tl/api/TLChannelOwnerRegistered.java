package io.objects.tl.api;


import io.objects.tl.TLContext;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.readTLString;
import static io.objects.tl.StreamUtils.writeString;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLChannelOwnerRegistered extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x87212bc7;

    private String botName;

    public TLChannelOwnerRegistered() {

    }

    public TLChannelOwnerRegistered(String botName) {
        setBotName(botName);
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public String toString() {
        return "channelOwnerRegistered#0x87212bc7";
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(botName, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        botName = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(botName);
        return size;
    }
}
