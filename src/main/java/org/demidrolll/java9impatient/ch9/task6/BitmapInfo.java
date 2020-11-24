package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.channels.ByteChannel;

/**
 *
 */
public interface BitmapInfo {
    int getImageDataSize();
    int getWidth();
    int getHeight();
    void read(ByteChannel channel) throws IOException;

    static BitmapInfo createByInfoSize(int infoHeaderSize) {
        if (infoHeaderSize == BitmapCoreHeader.TOTAL_DATA_SIZE) {
            return new BitmapCoreHeader();
        } else if (infoHeaderSize >= BitmapInfoHeader.TOTAL_DATA_SIZE) {
            return new BitmapInfoHeader();
        }
        throw new RuntimeException("Unknown header format");
    }
}
