package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;
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
        return reader;
    }

    @Override
    public void close() throws Exception {
        if (channel != null) {
            channel.close();
        }
    }
}
