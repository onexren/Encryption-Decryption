package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        //Default parameters
        String mode = "enc";
        int key = 0;
        String data = ""; //string data to encrypt or decrypt
        String in = ""; //read data path
        String out = ""; //write data path
        String alg = "shift";

        //Check input parameters
        for (int i = 1; i < args.length; i += 2) {
            //Check mode
            if ("-mode".equals(args[i-1]) && "dec".equals(args[i])) {
                mode = args[i];
            }
            //Check key
            if ("-key".equals(args[i-1])) {
                try {
                    key = Integer.parseInt(args[i]);
                } catch (Exception e) {
                    break;
                }
            }
            //Check data
            if ("-data".equals(args[i-1])) {
                data = args[i];
            }
            //Check input file
            if ("-in".equals(args[i-1])) {
                in = args[i];
            }
            //Check output file
            if ("-out".equals(args[i-1])) {
                out = args[i];
            }

            //Check algorithm
            if ("-alg".equals(args[i-1])) {
                alg = args[i];
            }

        }

        //Run program with algorithm

        if ("enc".equals(mode)) {
            Encryptor encryptor = new Encryptor();
            switch (alg) {
                case "shift": {
                    encryptor.setMethod(new EncryptorShift());
                    break;
                }
                case "unicode": {
                    encryptor.setMethod(new EncryptorUnicode());
                    break;
                }
                default: {
                    break;
                }
            }
            encryptor.encrypt(data, in, key, out);
        } else if ("dec".equals(mode)) {
            Decryptor decryptor = new Decryptor();
            switch (alg) {
                case "shift": {
                    decryptor.setMethod(new DecryptorShift());
                    break;
                }
                case "unicode": {
                    decryptor.setMethod(new DecryptorUnicode());
                    break;
                }
                default: {
                    break;
                }
            }
            decryptor.decrypt(data, in, key, out);
        }
    }
}




