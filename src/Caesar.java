import java.nio.charset.StandardCharsets;

public class Caesar {
    final static String ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final static String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static byte[] encodeBytes(byte[] array, int key) {
        String s = new String(array, StandardCharsets.UTF_8);
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            String s1 = String.valueOf(Character.toLowerCase(chars[i]));
            if (ENG_ALPHABET.contains(s1) || RU_ALPHABET.contains(s1)) {
                chars[i] = encodeChar(chars[i], key);
            }
        }
        s = new String(chars);
        return s.getBytes();
    }

    private static char encodeChar(char letter, int key) {
        char encodedChar = '0';
        boolean isUpperCase = Character.isUpperCase(letter);
        letter = Character.toLowerCase(letter);
        if (ENG_ALPHABET.contains(String.valueOf(letter))) {
            if (key < 0) key = ENG_ALPHABET.length() + key;
            encodedChar = ENG_ALPHABET.charAt((ENG_ALPHABET.indexOf(letter) + key) % ENG_ALPHABET.length());
        } else if (RU_ALPHABET.contains(String.valueOf(letter))) {
            if (key < 0) key = RU_ALPHABET.length() + key;
            encodedChar = RU_ALPHABET.charAt((RU_ALPHABET.indexOf(letter) + key) % RU_ALPHABET.length());
        }
        return isUpperCase ? Character.toUpperCase(encodedChar) : encodedChar;
    }
}
