package io.objects.tl.api;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLInputBotInlineResultPhoto extends TLAbsInputBotInlineResult {
    public static final int CONSTRUCTOR_ID = 0xa8d864a7;

    protected String type;

    protected TLAbsInputPhoto photo;

    private final String _constructor = "inputBotInlineResultPhoto#a8d864a7";

    public TLInputBotInlineResultPhoto() {
    }

    public TLInputBotInlineResultPhoto(String id, String type, TLAbsInputPhoto photo,
            TLAbsInputBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.photo = photo;
        this.sendMessage = sendMessage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(id, stream);
        writeString(type, stream);
        writeTLObject(photo, stream);
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLString(stream);
        type = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsInputPhoto.class, -1);
        sendMessage = readTLObject(stream, context, TLAbsInputBotInlineMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(id);
        size += computeTLStringSerializedSize(type);
        size += photo.computeSerializedSize();
        size += sendMessage.computeSerializedSize();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TLAbsInputPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsInputPhoto photo) {
        this.photo = photo;
    }

    public TLAbsInputBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsInputBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
