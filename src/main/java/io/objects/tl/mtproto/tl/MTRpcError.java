package io.objects.tl.mtproto.tl;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.objects.tl.StreamUtils.*;
import static io.objects.tl.TLObjectUtils.*;

public class MTRpcError extends TLObject {
    public static int CONSTRUCTOR_ID = 558156313;

    private static Pattern REGEXP_PATTERN = Pattern.compile("[A-Z_0-9]+");

    private int errorCode;

    private String message;

    public MTRpcError() {

    }

    public MTRpcError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "rpc_error#2144ca19";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(errorCode, stream);
        writeString(message, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        errorCode = readInt(stream);
        message = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(message);

        return size;
    }

    public String errorTag() {
        if (message.isEmpty())
            return "DEFAULT";

        Matcher matcher = REGEXP_PATTERN.matcher(message);
        if (matcher.find())
            return matcher.group();

        return "DEFAULT";
    }
}
