package io.objects.tl.api.request;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import io.objects.tl.api.TLBotUpdates;
import io.objects.tl.core.TLMethod;
import io.objects.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLRequestMonobotSignUp extends TLMethod<TLBotUpdates> {
    public static final int CONSTRUCTOR_ID = 0xbebc264;

    protected String botName;

    protected String userName;

    private final String _constructor = "monobot.signUp#bebc264";

    public TLRequestMonobotSignUp() {
    }

    public TLRequestMonobotSignUp(String botName, String userName) {
        this.botName = botName;
        this.userName = userName;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBotUpdates deserializeResponse(InputStream stream, TLContext context) throws
            IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBotUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBotUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(botName, stream);
        writeString(userName, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        botName = readTLString(stream);
        userName = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(botName);
        size += computeTLStringSerializedSize(userName);
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

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
