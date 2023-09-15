public class FrequencyPrinter {
    public static void printFrequencies(int[] count, String alphabet) {
        int sum = 0;
        for (int i : count) {
            sum += i;
        }

        drawHistogram(count, sum, alphabet);
    }
    private static void drawHistogram(int[] letters, int sum, String alphabet) {
        for (int i = 0 ; i < letters.length ; i++) {
            if (sum != 0) {
                System.out.printf("%c: %5.1f%% ", alphabet.charAt(i), ((double) letters[i] / (double) sum) * 100d);
                for (int j = 0; j < ((double) letters[i] / (double) sum) * 100; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}
