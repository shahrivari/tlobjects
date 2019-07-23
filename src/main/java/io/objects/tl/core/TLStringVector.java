package io.objects.tl.core;

import io.objects.tl.TLContext;
import io.objects.tl.TLObjectUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.objects.tl.StreamUtils.readTLString;
import static io.objects.tl.StreamUtils.writeString;
import static io.objects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.objects.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStringVector extends TLVector<String> {

    public TLStringVector() {
        super(String.class);
    }

    @Override
    protected void serializeItem(String item, OutputStream stream) throws IOException {
        writeString(item, stream);
    }

    @Override
    protected String deserializeItem(InputStream stream, TLContext context) throws IOException {
        return readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID + SIZE_INT32;
        for (String item : items)
            size += TLObjectUtils.computeTLStringSerializedSize(item);
        return size;
    }


    @Override
    public String toString() {
        return "vector<string>#1cb5c415";
    }
}
