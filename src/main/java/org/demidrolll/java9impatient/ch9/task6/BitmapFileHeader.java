package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/**
 *
 */
public class BitmapFileHeader {

    private static int TOTAL_DATA_SIZE = (3 * Short.SIZE + 2 * Integer.SIZE) / 8;

    private short signature;
    private int size;
    private short reserved1;
    private short reserved2;
    private int bitsOffset;

    public void read(ByteChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(TOTAL_DATA_SIZE);
        channel.read(buffer);
        buffer.position(0);
        signature = buffer.getShort();
        size = buffer.getInt();
        reserved1 = buffer.getShort();
        reserved2 = buffer.getShort();
        bitsOffset = buffer.getInt();
    }
}
