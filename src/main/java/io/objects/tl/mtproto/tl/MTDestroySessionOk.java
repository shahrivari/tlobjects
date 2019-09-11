package io.objects.tl.mtproto.tl;

import io.objects.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.readLong;
import static io.objects.tl.StreamUtils.writeLong;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.SIZE_INT64;

public class MTDestroySessionOk extends MTAbsDestroySessionResponse {
    public static final int CONSTRUCTOR_ID = 0xe7512126;

    private final String _constructor = "destroySessionOk#e7512126";

    public MTDestroySessionOk() {
    }

    public MTDestroySessionOk(long sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(sessionId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        sessionId = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        return size;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public String toString() {
        return _constructor;
    }
}
