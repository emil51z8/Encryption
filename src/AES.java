import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.SecureRandom;

public class AES {

    public SecretKey secretKey;
    byte[] keyBytes;
    Cipher cipher;

    public SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        keyGen.init(128, secureRandom); // 128, 192, or 256 bits
        return keyGen.generateKey();
    }

    public String AES_encrypt(String plaintext) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] plaintextBytes = plaintext.getBytes();
        byte[] ciphertextBytes = cipher.doFinal(plaintextBytes);
        String ciphertext = Base64.getEncoder().encodeToString(ciphertextBytes);
        return ciphertext;
    }

    public String AES_decrypt(String ciphertext) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        String decryptedText = new String(decryptedBytes);

        return decryptedText;
    }
    public AES() throws NoSuchAlgorithmException {
        this.secretKey = generateKey();
        keyBytes = secretKey.getEncoded();
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }
    public SecretKey getSecretKey() {
        return secretKey;
    }

    public byte[] getKeyBytes() {
        return keyBytes;
    }

}
