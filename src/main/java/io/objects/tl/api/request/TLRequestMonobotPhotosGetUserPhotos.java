package io.objects.tl.api.request;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import io.objects.tl.api.TLAbsInputUser;
import io.objects.tl.api.monobot.TLAbsBotPhotos;
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
public class TLRequestMonobotPhotosGetUserPhotos extends TLMethod<TLAbsBotPhotos> {
    public static final int CONSTRUCTOR_ID = 0x91d9c1e4;

    protected TLAbsInputUser userId;

    protected int offset;

    protected long maxId;

    protected int limit;

    protected long requestId;

    protected int botId;

    private final String _constructor = "monobot.photosGetUserPhotos#91d9c1e4";

    public TLRequestMonobotPhotosGetUserPhotos() {
    }

    public TLRequestMonobotPhotosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId,
            int limit, long requestId, int botId) {
        this.userId = userId;
        this.offset = offset;
        this.maxId = maxId;
        this.limit = limit;
        this.requestId = requestId;
        this.botId = botId;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsBotPhotos deserializeResponse(InputStream stream, TLContext context) throws
            IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsBotPhotos)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsBotPhotos) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(userId, stream);
        writeInt(offset, stream);
        writeLong(maxId, stream);
        writeInt(limit, stream);
        writeLong(requestId, stream);
        writeInt(botId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        offset = readInt(stream);
        maxId = readLong(stream);
        limit = readInt(stream);
        requestId = readLong(stream);
        botId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += userId.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getBotId() {
        return botId;
    }

    public void setBotId(int botId) {
        this.botId = botId;
    }
}
