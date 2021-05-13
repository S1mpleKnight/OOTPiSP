package by.bsuir.oop.fourth.encryption.api;

import java.util.List;

public interface Cipher {
    String encrypt(List<String> list);

    String decrypt(List<String> list);
}
