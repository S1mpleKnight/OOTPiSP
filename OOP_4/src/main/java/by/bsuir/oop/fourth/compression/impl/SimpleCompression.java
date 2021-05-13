package by.bsuir.oop.fourth.compression.impl;

import by.bsuir.oop.fourth.compression.api.Compression;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class SimpleCompression implements Compression {
    private static final int COMPRESSION_LEVEL = 6;
    private static final int BUFFER_SIZE = 512;

    @Override
    public String compression(String text) {
        byte[] data = text.getBytes();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(BUFFER_SIZE);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(COMPRESSION_LEVEL));
            dos.write(data);
            dos.flush();
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public String decompression(String text) {
        byte[] data = Base64.getDecoder().decode(text);
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(BUFFER_SIZE);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return bout.toString();
        } catch (IOException ex) {
            return null;
        }
    }
}
