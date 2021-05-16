package encryption;

public interface Cipher {
    String encrypt(String text) throws Exception;

    String decrypt(String text) throws Exception;
}
