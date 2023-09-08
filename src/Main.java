import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("""
                    Too little arguments!
                    arg 1: file name
                    arg 2: int key
                    arg 3: locale (ru/eng)
                    """);
            System.exit(1);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream((args[0]) + "_encrypted")) {

                byte[] buffer = new byte[16];
                int count;

                while ( (count = fileInputStream.read(buffer)) != -1 ) {
                    fileOutputStream.write(Caesar.encode(buffer), 0, count);
                }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}