package encryptdecrypt;

public class Encryptor {
    private EncryptingMethod method;

    public void setMethod(EncryptingMethod method) {
        this.method = method;
    }

    public void encrypt(String data, String in, int key, String out) {
        this.method.encrypt(data, in, key, out);
    }
}
