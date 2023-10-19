    import java.security.*;

    public class Sha {


        MessageDigest md = MessageDigest.getInstance("SHA-1");

        public String SHA_encrypt(String input)
        {
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            String shaHash = hexString.toString();
            return shaHash;
        }
        public Sha() throws NoSuchAlgorithmException {
        }
    }

