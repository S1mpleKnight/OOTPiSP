package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.container.Container;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class BinarySerialize implements SerializeStrategy {
    private static BinarySerialize binaryVersion;

    private BinarySerialize() {
    }

    public static BinarySerialize getBinaryVersion() {
        if (binaryVersion == null) {
            binaryVersion = new BinarySerialize();
        }
        return binaryVersion;
    }


    public Container read(File file) {
        Container container = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()))) {
            container = (Container) ois.readObject();
        } catch (FileNotFoundException exception) {
            System.out.println("Read: File not found");

        } catch (IOException exception) {
            System.out.println("Read: I/O exception");

        } catch (ClassNotFoundException e) {
            System.out.println("Read: Class not found");

        }
        return container;
    }

    @Override
    public String write(File file, Container container) {
        String result;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            oos.writeObject(container);
            result = "Success";
        } catch (FileNotFoundException exception) {
            System.out.println("Write: File not found");
            result = "File not found";
        } catch (IOException exception) {
            result = "I/O exception";
            System.out.println("Write: I/O exception");
        }
        return result;
    }
}
