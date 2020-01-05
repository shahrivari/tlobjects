package io.objects.tl.api;

import io.objects.tl.TLContext;
import io.objects.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.readTLString;
import static io.objects.tl.StreamUtils.writeString;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLGraceConfig extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x9c371309;

    private String marqueeText;

    private final String _constructor = "graceConfig#9c371309";

    public TLGraceConfig() {
    }

    public TLGraceConfig(String marqueeText) {
        this.marqueeText = marqueeText;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(marqueeText, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        marqueeText = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(marqueeText);
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

    public String getMarqueeText() {
        return marqueeText;
    }

    public void setMarqueeText(String marqueeText) {
         this.marqueeText = marqueeText;
    }
}
