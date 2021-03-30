package by.bsuir.oop.third.serialization;

import by.bsuir.oop.third.furniture.Table;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Table> read(File file) {
        List<Table> tables;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()))){
            tables = ((ArrayList<Table>) ois.readObject());
        } catch (FileNotFoundException exception) {
            System.out.println("Read: File not found");
            tables = Collections.emptyList();
        } catch (IOException exception) {
            System.out.println("Read: I/O exception");
            tables = Collections.emptyList();
        } catch (ClassNotFoundException e) {
            System.out.println("Read: Class not found");
            tables = Collections.emptyList();
        }
        return tables;
    }

    @Override
    public String write(File file, List<Table> tables) {
        String result;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()))){
            oos.writeObject(tables);
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
