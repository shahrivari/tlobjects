package io.tlobjects.tl.api.messages;

import static io.tlobjects.tl.StreamUtils.*;
import static io.tlobjects.tl.TLObjectUtils.*;

import io.tlobjects.tl.TLContext;
import io.tlobjects.tl.api.TLAbsEncryptedFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * This class is generated by Mono's TL class generator
 */
public class TLSentEncryptedFile extends TLAbsSentEncryptedMessage {
    public static final int CONSTRUCTOR_ID = 0x9493ff32;

    protected TLAbsEncryptedFile file;

    private final String _constructor = "messages.sentEncryptedFile#9493ff32";

    public TLSentEncryptedFile() {
    }

    public TLSentEncryptedFile(int date, TLAbsEncryptedFile file) {
        this.date = date;
        this.file = file;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(date, stream);
        writeTLObject(file, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        date = readInt(stream);
        file = readTLObject(stream, context, TLAbsEncryptedFile.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += file.computeSerializedSize();
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsEncryptedFile getFile() {
        return file;
    }

    public void setFile(TLAbsEncryptedFile file) {
        this.file = file;
    }
}
