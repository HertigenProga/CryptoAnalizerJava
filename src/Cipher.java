// text - входной текст
// shift - величина сдвига
// c - текущий символ текста

public class Cipher {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789" +
            " " +
            ".,!?\"'";

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);

            if (index == -1) {              // Есть ли этот символ в алфавите?
                result.append(c);           // Символ не из алфавита
            } else {
                int newIndex = (index + shift) % ALPHABET.length();     // без % будет ошибка
                result.append(ALPHABET.charAt(newIndex));
            }

        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {

        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);

            if (index == -1) {
                result.append(c);
            } else {
                int newIndex = (index - shift + ALPHABET.length()) % ALPHABET.length();     // Сначала гарантировать положительное число, потом зациклить
                result.append(ALPHABET.charAt(newIndex));
            }
        }
        return result.toString();
    }
}


