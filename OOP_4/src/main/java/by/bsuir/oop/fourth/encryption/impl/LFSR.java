package by.bsuir.oop.fourth.encryption.impl;

import by.bsuir.oop.fourth.encryption.api.Cipher;

import java.nio.charset.StandardCharsets;

public class LFSR implements Cipher {
    private static final long KEY_MASK = 0b00000000_00000000_00000000_00000001_11111110_00000000_00000000_00000000L;
    private static final int KEY = 0b00000001_11111111_11111111_11111111;
    private byte[] message;
    private int key;

    public LFSR() {
    }

    public String encrypt(String text) {
        key = KEY;
        message = text.getBytes();
        byte[] encryptBytes = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            encryptBytes[i] = manipulateByte(message[i]);
        }
        return new String(encryptBytes);
    }

    private byte manipulateByte(byte sequence) {
        byte keyByte = createNextKeyByte();
        return (byte) (keyByte ^ sequence);
    }

    private byte createNextKeyByte() {
        long temp = key;
        for (int i = 0; i < 8; i++) {
            int bit = calculateLastBit(temp);
            temp <<= 1;
            temp += bit;
        }
        key = (int) temp;
        return (byte) ((temp & KEY_MASK) >> 25);
    }

    private int calculateLastBit(long temp) {
        String binary = Integer.toBinaryString((int) temp);
        if (binary.length() < 3) {
            System.out.println("first");
            return 0;
        }
        int third = binary.charAt(binary.length() - 3) - '0';
        if (binary.length() < 25) {
            return third;
        }
        int twentyFifth = binary.charAt(binary.length() - 25) - '0';
        return twentyFifth ^ third;
    }

    public String decrypt(String text) {
        key = KEY;
        message = text.getBytes();
        byte[] decryptBytes = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            decryptBytes[i] = manipulateByte(message[i]);
        }
        return new String(decryptBytes);
    }
}
