import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FrequencyAnalyzer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("""
                    Wrong number of arguments
                    
                    arg 1: file name
                    """);
            System.exit(1);
        }

        int[] engCount = new int[Caesar.ENG_ALPHABET.length()];
        int[] ruCount = new int[Caesar.RU_ALPHABET.length()];

        for (int i = 0 ; i < Caesar.ENG_ALPHABET.length() ; i++) {
            engCount[i] = 0;
        }

        for (int i = 0 ; i < Caesar.RU_ALPHABET.length() ; i++) {
            ruCount[i] = 0;
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            byte[] buffer = new byte[1024];

            while (fileInputStream.read(buffer) != -1) {
                String s = new String(buffer, StandardCharsets.UTF_8);
                s = s.toLowerCase();
                char[] letters = s.toCharArray();
                for (char letter : letters) {
                    if (Caesar.ENG_ALPHABET.contains(String.valueOf(letter))) {
                        engCount[Caesar.ENG_ALPHABET.indexOf(letter)]++;
                    }
                    if (Caesar.RU_ALPHABET.contains(String.valueOf(letter))) {
                        ruCount[Caesar.RU_ALPHABET.indexOf(letter)]++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        FrequencyPrinter.printFrequencies(engCount, Caesar.ENG_ALPHABET);
        FrequencyPrinter.printFrequencies(ruCount, Caesar.RU_ALPHABET);
    }
}
