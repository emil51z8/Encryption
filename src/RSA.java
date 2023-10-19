import java.security.*;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    Cipher encryptCipher = Cipher.getInstance("RSA");
    Cipher decryptCipher = Cipher.getInstance("RSA");

    public RSA() throws NoSuchAlgorithmException, NoSuchPaddingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size (adjust as needed)
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }
    public byte[] RSA_encrypt(String text, PublicKey publicKey ) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = encryptCipher.doFinal(text.getBytes());
        return encryptedData;
    }

    public String RSA_decrypt(byte[] encryptedData) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = decryptCipher.doFinal(encryptedData);
        String plaintext = new String(decryptedData);
        return plaintext;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}