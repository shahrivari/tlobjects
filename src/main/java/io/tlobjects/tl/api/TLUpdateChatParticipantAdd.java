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
public class TLUpdateChatParticipantAdd extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xea4b0e5c;

    protected int chatId;

    protected int userId;

    protected int inviterId;

    protected int date;

    protected int version;

    private final String _constructor = "updateChatParticipantAdd#ea4b0e5c";

    public TLUpdateChatParticipantAdd() {
    }

    public TLUpdateChatParticipantAdd(int chatId, int userId, int inviterId, int date,
            int version) {
        this.chatId = chatId;
        this.userId = userId;
        this.inviterId = inviterId;
        this.date = date;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(chatId, stream);
        writeInt(userId, stream);
        writeInt(inviterId, stream);
        writeInt(date, stream);
        writeInt(version, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readInt(stream);
        userId = readInt(stream);
        inviterId = readInt(stream);
        date = readInt(stream);
        version = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
