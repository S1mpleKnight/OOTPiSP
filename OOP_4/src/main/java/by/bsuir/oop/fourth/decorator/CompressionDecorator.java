package by.bsuir.oop.fourth.decorator;

import by.bsuir.oop.fourth.compression.api.Compression;
import by.bsuir.oop.fourth.util.api.FileWorker;

import java.io.File;
import java.io.IOException;

public final class CompressionDecorator extends FileWorkerDecorator{
    private Compression compression;

    public CompressionDecorator(FileWorker worker, Compression compression) {
        super(worker);
        this.compression = compression;
    }

    @Override
    public String readFile(File file) throws IOException {
        return compression.decompression(super.readFile(file));
    }

    @Override
    public boolean writeFile(File file, String text) throws IOException {
        return super.writeFile(file, compression.compression(text));
    }
}
