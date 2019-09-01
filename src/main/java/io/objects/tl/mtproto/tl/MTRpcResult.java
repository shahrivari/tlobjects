package io.objects.tl.mtproto.tl;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

public class MTRpcResult extends TLObject {
    public static int CONSTRUCTOR_ID = 0xf35c6d01;

    private long messageId;

    private byte[] content;

    private int contentLen;

    public MTRpcResult() {

    }

    public MTRpcResult(long messageId, byte[] content, int contentLen) {
        this.messageId = messageId;
        this.content = content;
        this.contentLen = contentLen;
    }

    public static io.objects.tl.mtproto.tl.MTRpcResult createFrom(long msgId, TLObject obj) throws IOException {
        io.objects.tl.mtproto.tl.MTRpcResult rpcResult = new io.objects.tl.mtproto.tl.MTRpcResult();
        rpcResult.messageId = msgId;
        rpcResult.content = obj.serialize();
        rpcResult.contentLen = rpcResult.content.length;
        return rpcResult;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getContentLen() {
        return contentLen;
    }

    public void setContentLen(int contentLen) {
        this.contentLen = contentLen;
    }

    @Override
    public String toString() {
        return "rpc_result#f35c6d01";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(messageId, stream);
        writeTLBytes(content, stream);
        writeInt(contentLen, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        messageId = readLong(stream);
        content = readTLBytes(stream);
        contentLen = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(content.length);
        size += SIZE_INT32;

        return size;
    }
}