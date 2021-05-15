package by.bsuir.oop.fourth.encryption.impl;

import by.bsuir.oop.fourth.encryption.api.Cipher;

import java.util.Base64;

public class SimpleCipher implements Cipher {

    @Override
    public String encrypt(String text) {
        byte[] result = text.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    @Override
    public String decrypt(String text) {
        byte[] result = Base64.getDecoder().decode(text);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
