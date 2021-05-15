package encryption;

public interface Cipher {
    String encrypt(String text);

    String decrypt(String text);
}
