package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.ByteChannel;

/**
 *
 */
public class BitmapFileHeader {

    public static final int TOTAL_DATA_SIZE = 3 * Short.BYTES + 2 * Integer.BYTES;

    private short signature;
    private int size;
    private short reserved1;
    private short reserved2;
    private int bitsOffset;

    public void read(ByteChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(TOTAL_DATA_SIZE).order(ByteOrder.LITTLE_ENDIAN);
        channel.read(buffer);
        buffer.position(0);
        signature = buffer.getShort();
        size = buffer.getInt();
        reserved1 = buffer.getShort();
        reserved2 = buffer.getShort();
        bitsOffset = buffer.getInt();
    }

    public short getSignature() {
        return signature;
    }

    public int getSize() {
        return size;
    }

    public short getReserved1() {
        return reserved1;
    }

    public short getReserved2() {
        return reserved2;
    }

    public int getBitsOffset() {
        return bitsOffset;
    }
}
