package encryptdecrypt;

import java.io.IOException;

public class EncryptorShift implements EncryptingMethod {
    private static void methodShift(char[] inputArray, int key) {
        char min1 = 'a';     //'a' = int 97;
        char max1 = 'z';     //'z' = int 122;
        char min2 = 'A';     //'A' = int ;
        char max2 = 'Z';     //'Z' = int ;
        for (int i = 0; i < inputArray.length; i++) {
            /*
            To encrypt the message, replace each letter with the letter
            that is in the corresponding position from the end of the
            English alphabet (a?z, b?y, c?x, ... x?c, y ?b, z?a).
            Do not replace spaces or the exclamation mark.
            */
            if (inputArray[i] >= min1 && inputArray[i] <= max1) {
                int originalAlphabetPosition = inputArray[i] - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                inputArray[i] = newCharacter;
            }

            if (inputArray[i] >= min2 && inputArray[i] <= max2) {
                int originalAlphabetPosition = inputArray[i] - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                inputArray[i] = newCharacter;
            }
        }
    }

    @Override
    public void encrypt(String data, String in, int key, String out) {
        if (!"".equals(in)) {
            try {
                String inStr = ReadingFile.readFileAsString(in);
                char[] inputArray = inStr.toCharArray();
                methodShift(inputArray, key);
                data = new String(inputArray);
            } catch (IOException e) {
                System.out.println("Cannot read file: " + e.getMessage());
            }
        } else {
            char[] inputArray = data.toCharArray();
            methodShift(inputArray, key);
            data = new String(inputArray);
        }

        if (!"".equals(out)) {
            WritingFile.WriteFileAsString(out, data);
        } else System.out.println(data);
    }
}

