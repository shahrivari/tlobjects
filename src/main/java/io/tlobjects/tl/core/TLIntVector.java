package io.tlobjects.tl.core;

import io.tlobjects.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.tlobjects.tl.StreamUtils.readInt;
import static io.tlobjects.tl.StreamUtils.writeInt;
import static io.tlobjects.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static io.tlobjects.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLIntVector extends TLVector<Integer> {

    public TLIntVector() {
        super(Integer.class);
    }

    @Override
    protected void serializeItem(Integer item, OutputStream stream) throws IOException {
        writeInt(item, stream);
    }

    @Override
    protected Integer deserializeItem(InputStream stream, TLContext context) throws IOException {
        return readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        return SIZE_CONSTRUCTOR_ID + SIZE_INT32 + SIZE_INT32 * size();
    }

    @Override
    public String toString() {
        return "vector<int>#1cb5c415";
    }

    public int[] toIntArray() {
        int[] array = new int[size()];
        for (int i = 0; i < array.length; i++)
            array[i] = items.get(i);
        return array;
    }
}
