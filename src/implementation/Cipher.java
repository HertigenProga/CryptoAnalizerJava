package implementation;

import interfaces.CipherAlgorithm;

public class Cipher implements CipherAlgorithm {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789" +
            " " +
            ".,!?\"'";

    @Override
    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);

            if (index == -1) {
                result.append(c);
            } else {
                int newIndex = (index + shift) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            }

        }
        return result.toString();
    }
    @Override
    public String decrypt(String text, int shift) {

        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);

            if (index == -1) {
                result.append(c);
            } else {
                int newIndex = (index - shift + ALPHABET.length()) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            }
        }
        return result.toString();
    }
}


