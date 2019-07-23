package io.tlobjects.tl.api.upload;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.core.TLBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLCdnFileReuploadNeeded extends TLAbsCdnFile {
    public static final int CONSTRUCTOR_ID = 0xeea8e46e;

    protected TLBytes requestToken;

    private final String _constructor = "upload.cdnFileReuploadNeeded#eea8e46e";

    public TLCdnFileReuploadNeeded() {
    }

    public TLCdnFileReuploadNeeded(TLBytes requestToken) {
        this.requestToken = requestToken;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(requestToken, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        requestToken = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(requestToken);
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

    public TLBytes getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(TLBytes requestToken) {
        this.requestToken = requestToken;
    }
}
