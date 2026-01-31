package interfaces;

public interface CipherAlgorithm {
    String encrypt(String text, int shift);
    String decrypt(String text, int shift);
}
