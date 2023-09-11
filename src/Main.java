import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    final static String PREFIX = "processed_";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("""
                    Wrong number of arguments
                    
                    arg 1: file name
                    arg 2: int key
                    """);
            System.exit(1);
        }

        int key = 0;
        try {
            key = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(PREFIX + (args[0]))) {

                byte[] buffer = new byte[1024];
                int count;

                while ( (count = fileInputStream.read(buffer)) != -1 ) {
                    fileOutputStream.write(Caesar.encodeBytes(buffer, key), 0, count);
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(args[0] + " encrypted as " + PREFIX + args[0]);
    }
}