import java.nio.charset.StandardCharsets;

public class Caesar {
    public static byte[] encode(byte[] array) {
        String s = new String(array, StandardCharsets.UTF_8);
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            chars[i] += 1; // TODO key set
            System.out.print(chars[i]);
        }
        s = new String(chars);
//        System.out.println(s);
        return s.getBytes();
    }
}
