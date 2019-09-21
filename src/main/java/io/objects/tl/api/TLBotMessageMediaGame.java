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
public class TLBotMessageMediaGame extends TLAbsBotMessageMedia {
    public static final int CONSTRUCTOR_ID = 0xfcc32029;

    protected TLGame game;

    private final String _constructor = "botMessageMediaGame#fcc32029";

    public TLBotMessageMediaGame() {
    }

    public TLBotMessageMediaGame(TLGame game, long requestId, int responseCode, String error) {
        this.game = game;
        this.requestId = requestId;
        this.responseCode = responseCode;
        this.error = error;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(game, stream);
        writeLong(requestId, stream);
        writeInt(responseCode, stream);
        writeString(error, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        game = readTLObject(stream, context, TLGame.class, TLGame.CONSTRUCTOR_ID);
        requestId = readLong(stream);
        responseCode = readInt(stream);
        error = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += game.computeSerializedSize();
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(error);
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

    public TLGame getGame() {
        return game;
    }

    public void setGame(TLGame game) {
        this.game = game;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
