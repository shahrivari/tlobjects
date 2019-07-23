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
public class TLChatParticipantsForbidden extends TLAbsChatParticipants {
    public static final int CONSTRUCTOR_ID = 0xfc900c2b;

    protected int flags;

    protected TLAbsChatParticipant selfParticipant;

    private final String _constructor = "chatParticipantsForbidden#fc900c2b";

    public TLChatParticipantsForbidden() {
    }

    public TLChatParticipantsForbidden(int chatId, TLAbsChatParticipant selfParticipant) {
        this.chatId = chatId;
        this.selfParticipant = selfParticipant;
    }

    private void computeFlags() {
        flags = 0;
        flags = selfParticipant != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(chatId, stream);
        if ((flags & 1) != 0) {
            if (selfParticipant == null) throwNullFieldException("selfParticipant", flags);
            writeTLObject(selfParticipant, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        chatId = readInt(stream);
        selfParticipant = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsChatParticipant.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (selfParticipant == null) throwNullFieldException("selfParticipant", flags);
            size += selfParticipant.computeSerializedSize();
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

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public TLAbsChatParticipant getSelfParticipant() {
        return selfParticipant;
    }

    public void setSelfParticipant(TLAbsChatParticipant selfParticipant) {
        this.selfParticipant = selfParticipant;
    }
}
