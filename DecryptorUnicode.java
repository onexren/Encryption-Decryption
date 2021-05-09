package encryptdecrypt;

import java.io.IOException;

public class DecryptorUnicode implements DecryptingMethod {
    private static void methodUnicode(char[] inputArray, int key) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (char) (inputArray[i] - key);
        }
    }
    @Override
    public void decrypt(String data, String in, int key, String out) {
        if (!"".equals(in)) {
            try {
                String inStr = ReadingFile.readFileAsString(in);
                char[] inputArray = inStr.toCharArray();
                methodUnicode(inputArray, key);
                data = new String(inputArray);
            } catch (IOException e) {
                System.out.println("Cannot read file: " + e.getMessage());
            }
        } else {
            char[] inputArray = data.toCharArray();
            methodUnicode(inputArray, key);
            data = new String(inputArray);
        }

        if (!"".equals(out)) {
            WritingFile.WriteFileAsString(out, data);
        } else System.out.println(data);
    }
}

