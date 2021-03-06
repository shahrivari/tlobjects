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
public class TLChannelAdminLogEventActionEditMessage extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x709b2405;

    protected TLAbsMessage prevMessage;

    protected TLAbsMessage newMessage;

    private final String _constructor = "channelAdminLogEventActionEditMessage#709b2405";

    public TLChannelAdminLogEventActionEditMessage() {
    }

    public TLChannelAdminLogEventActionEditMessage(TLAbsMessage prevMessage,
            TLAbsMessage newMessage) {
        this.prevMessage = prevMessage;
        this.newMessage = newMessage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevMessage, stream);
        writeTLObject(newMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevMessage = readTLObject(stream, context, TLAbsMessage.class, -1);
        newMessage = readTLObject(stream, context, TLAbsMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevMessage.computeSerializedSize();
        size += newMessage.computeSerializedSize();
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

    public TLAbsMessage getPrevMessage() {
        return prevMessage;
    }

    public void setPrevMessage(TLAbsMessage prevMessage) {
        this.prevMessage = prevMessage;
    }

    public TLAbsMessage getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(TLAbsMessage newMessage) {
        this.newMessage = newMessage;
    }
}
