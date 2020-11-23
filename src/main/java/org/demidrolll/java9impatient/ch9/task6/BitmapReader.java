package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
import java.nio.ByteBuffer;
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
    }

    @Override
    public void close() throws Exception {
        if (channel != null) {
            channel.close();
        }
    }
}
