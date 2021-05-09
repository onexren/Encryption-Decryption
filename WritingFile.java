package encryptdecrypt;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class WritingFile {
    public static void WriteFileAsString(String out, String outData) {
        File file = new File(out);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print(outData); // prints a string
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}

