package io.objects.tl.api.monobot;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

import io.objects.tl.TLContext;
import io.objects.tl.api.storage.TLAbsFileType;
import io.objects.tl.core.TLBytes;
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
public class TLBotFile extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x95ba1b5;

    protected TLAbsFileType type;

    protected int mtime;

    protected TLBytes bytes;

    protected long requestId;

    protected int responseCode;

    protected String error;

    private final String _constructor = "monobot.botFile#95ba1b5";

    public TLBotFile() {
    }

    public TLBotFile(TLAbsFileType type, int mtime, TLBytes bytes, long requestId, int responseCode,
            String error) {
        this.type = type;
        this.mtime = mtime;
        this.bytes = bytes;
        this.requestId = requestId;
        this.responseCode = responseCode;
        this.error = error;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(type, stream);
        writeInt(mtime, stream);
        writeTLBytes(bytes, stream);
        writeLong(requestId, stream);
        writeInt(responseCode, stream);
        writeString(error, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLObject(stream, context, TLAbsFileType.class, -1);
        mtime = readInt(stream);
        bytes = readTLBytes(stream, context);
        requestId = readLong(stream);
        responseCode = readInt(stream);
        error = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += type.computeSerializedSize();
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(bytes);
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

    public TLAbsFileType getType() {
        return type;
    }

    public void setType(TLAbsFileType type) {
        this.type = type;
    }

    public int getMtime() {
        return mtime;
    }

    public void setMtime(int mtime) {
        this.mtime = mtime;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
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