package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ByteChannel;

/**
 *
 */
public class BitmapInfoHeader implements BitmapInfo {

    public static final int TOTAL_DATA_SIZE = 9 * Integer.BYTES + 2 * Short.BYTES;

    private int width;
    private int height;
    private short planes;
    private short bitCount;
    private int compression;
    private int imageSize;
    private int xPixelsPerMeter;
    private int yPixelsPerMeter;
    private int usedColor;
    private int importantColor;

    @Override
    public int getImageDataSize() {
        if (imageSize == 0) {
            return width * height * (bitCount / 8);
        } else {
            return imageSize;
        }
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
        width = buffer.getInt();
        height = buffer.getInt();
        planes = buffer.getShort();
        bitCount = buffer.getShort();
        compression = buffer.getInt();
        imageSize = buffer.getInt();
        xPixelsPerMeter = buffer.getInt();
        yPixelsPerMeter = buffer.getInt();
        usedColor = buffer.getInt();
        importantColor = buffer.getInt();
    }
}
