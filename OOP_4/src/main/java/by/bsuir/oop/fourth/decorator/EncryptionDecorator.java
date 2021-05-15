package by.bsuir.oop.fourth.decorator;

import by.bsuir.oop.fourth.util.api.FileWorker;
import encryption.Cipher;

import java.io.File;
import java.io.IOException;

public final class EncryptionDecorator extends FileWorkerDecorator{
    private Cipher cipher;

    public EncryptionDecorator(FileWorker worker, Cipher cipher) {
        super(worker);
        this.cipher = cipher;
    }

    @Override
    public String readFile(File file) throws IOException {
        return cipher.decrypt(super.readFile(file));
    }

    @Override
    public boolean writeFile(File file, String text) throws IOException {
        return super.writeFile(file, cipher.encrypt(text));
    }
}
