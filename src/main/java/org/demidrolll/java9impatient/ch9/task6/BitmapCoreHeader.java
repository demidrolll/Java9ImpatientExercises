package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ByteChannel;

/**
 *
 */
public class BitmapCoreHeader implements BitmapInfo {

    public static int TOTAL_DATA_SIZE = Integer.BYTES + 4 * Short.BYTES;

    private short width;
    private short height;
    private short planes;
    private short bitCount;

    @Override
    public int getImageDataSize() {
        return (width * 3 + width % 4) * height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void read(ByteChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(TOTAL_DATA_SIZE).order(ByteOrder.LITTLE_ENDIAN);
        channel.read(buffer);
        buffer.position(0);
        width = buffer.getShort();
        height = buffer.getShort();
        planes = buffer.getShort();
        bitCount = buffer.getShort();
    }
}
