package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 */
public class BitmapReader implements AutoCloseable {

    private SeekableByteChannel channel;

    private BitmapReader() {
    }

    public static BitmapReader open(String filename) throws IOException {
        BitmapReader reader = new BitmapReader();
        reader.channel = Files.newByteChannel(Paths.get(filename));
        reader.readData();
        return reader;
    }

    private void readData() throws IOException {
        channel = channel.position(0);
        BitmapFileHeader header = new BitmapFileHeader();
        header.read(channel);
        ByteBuffer sizeBuffer = ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        channel.read(sizeBuffer);
        int infoHeaderSize = sizeBuffer.position(0).getInt();
        BitmapInfo info = BitmapInfo.createByInfoSize(infoHeaderSize);
        info.read(channel);

        ByteBuffer dataBuffer = ByteBuffer.allocate(info.getImageDataSize()).order(ByteOrder.LITTLE_ENDIAN);
        channel.position(header.getBitsOffset()).read(dataBuffer);
    }

    @Override
    public void close() throws Exception {
        if (channel != null) {
            channel.close();
        }
    }
}
