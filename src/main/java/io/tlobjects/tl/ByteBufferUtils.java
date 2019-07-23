package io.tlobjects.tl;

import io.tlobjects.tl.core.TLBytes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class ByteBufferUtils {

    public static void writeByte(byte v, ByteBuffer buffer) throws IOException {
        buffer.put(v);
    }

    public static void writeByte(int v, ByteBuffer buffer) throws IOException {
        buffer.put((byte) (v & 0xFF));
    }

    public static void writeByteArray(byte[] data, ByteBuffer buffer) throws IOException {
        buffer.put(data);
    }

    public static void writeByteArray(byte[] data, int offset, int length, ByteBuffer buffer) throws IOException {
        buffer.put(data, offset, length);
    }

    public static void writeInt(int v, ByteBuffer buffer) throws IOException {
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(v);
        buffer.order(ByteOrder.BIG_ENDIAN);
    }

    public static void writeInt24(int v, ByteBuffer buffer) throws IOException {
        writeByte(v, buffer);
        writeByte(v >> 8, buffer);
        writeByte(v >> 16, buffer);
    }

    public static void writeLong(long v, ByteBuffer buffer) throws IOException {
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(v);
        buffer.order(ByteOrder.BIG_ENDIAN);
    }

    public static void writeDouble(double v, ByteBuffer buffer) throws IOException {
        writeLong(Double.doubleToRawLongBits(v), buffer);
    }

    public static void writeTLBytes(TLBytes v, ByteBuffer buffer) throws IOException {
        int length = v.getLength();

        // see https://core.telegram.org/mtproto/serialize#base-types
        if (length >= 254) {
            writeByte(254, buffer);
            writeInt24(length, buffer);
        } else
            writeByte(length, buffer);

        writeByteArray(v.getData(), v.getOffset(), length, buffer);

        int offset = (length + (length <= 253 ? 1 : 4)) % 4;
        if (offset > 0)
            writeByteArray(new byte[4 - offset], buffer);
    }

    public static void writeTLBytes(byte[] v, ByteBuffer buffer) throws IOException {
        writeTLBytes(new TLBytes(v), buffer);
    }

    public static void writeString(String v, ByteBuffer buffer) throws IOException {
        writeTLBytes(v.getBytes(Charset.forName("UTF-8")), buffer);
    }

    public static byte readByte(ByteBuffer buffer) throws IOException {
        return buffer.get();
    }

    public static int readByteAsInt(ByteBuffer buffer) throws IOException {
        return ((int) buffer.get()) & 0xff;
        // API Level 1.8
    }

    public static void readBytes(byte[] dest, int offset, int length, ByteBuffer buffer) throws IOException {
        buffer.get(dest, offset, length);
    }

    public static byte[] readBytes(int length, ByteBuffer buffer) throws IOException {
        byte[] bytes = new byte[length];
        buffer.get(bytes);
        return bytes;
    }

    public static int readInt(ByteBuffer buffer) throws IOException {
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int value = buffer.getInt();
        buffer.order(ByteOrder.BIG_ENDIAN);
        return value;
    }

    public static int readInt24(ByteBuffer buffer) throws IOException {
        byte[] values = new byte[4];
        values[3] = 0;
        buffer.get(values, 0, 3); // Read 3 bytes
        ByteBuffer value = ByteBuffer.wrap(values);
        value.order(ByteOrder.LITTLE_ENDIAN);
        return value.getInt();
    }

    public static long readLong(ByteBuffer buffer) throws IOException {
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        long value = buffer.getLong();
        buffer.order(ByteOrder.BIG_ENDIAN);
        return value;
    }

    public static double readDouble(ByteBuffer buffer) throws IOException {
        return Double.longBitsToDouble(readLong(buffer));
    }

    public static TLBytes readTLBytes(ByteBuffer buffer) throws IOException {
        int length = readByteAsInt(buffer);

        // see https://core.telegram.org/mtproto/serialize#base-types
        if (length == 254)
            length = readInt24(buffer);

        byte[] bytes = readBytes(length, buffer);
        int offset = (length + (length <= 253 ? 1 : 4)) % 4;
        if (offset > 0)
            buffer.position(buffer.position() + (4 - offset));

        return new TLBytes(bytes, 0, length);
    }

    public static String readTLString(ByteBuffer buffer) throws IOException {
        return new String(readTLBytes(buffer).getData(), "UTF-8");
    }
}