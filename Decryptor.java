package encryptdecrypt;

public class Decryptor {
    private DecryptingMethod method;

    public void setMethod(DecryptingMethod method) {
        this.method = method;
    }

    public void decrypt(String data, String in, int key, String out) {
        this.method.decrypt(data, in, key, out);
    }
}
