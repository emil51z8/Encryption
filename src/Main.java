import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

        public class Main {


            private static String bruteForce(String targetHash, int length, Sha sha) {
                char[] characters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                StringBuilder sb = new StringBuilder(length);

                return bruteForceRecursion(targetHash, characters, sb, length, 0, sha);
            }

            private static String bruteForceRecursion(String targetHash, char[] characters, StringBuilder sb, int length, int position, Sha sha) {
                if (position == length) {
                    String candidate = sb.toString();
                    String hashed = sha.SHA_encrypt(candidate);
                    if (hashed.equals(targetHash)) {
                        return candidate;
                    }
                    return null;
                }

                for (char c : characters) {
                    sb.append(c);
                    String result = bruteForceRecursion(targetHash, characters, sb, length, position + 1, sha);
                    if (result != null) {
                        return result;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }

                return null;
            }
            public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        /*AES aes = new AES();
        String text ="Hej mit navn er Emil";
        System.out.println(text);
        String encrypted = aes.AES_encrypt(text);
        System.out.println(encrypted);
        String decrypted = aes.AES_decrypt(encrypted);
        System.out.println(decrypted);

        String text2 ="Hej mit navn er Amil";
        System.out.println(text2);
        String encrypted2 = aes.AES_encrypt(text2);
        System.out.println(encrypted2);
        String decrypted2 = aes.AES_decrypt(encrypted2);
        System.out.println(decrypted2);

        RSA person1 = new RSA();
        RSA person2 = new RSA();

        String message = "Hemmelig besked";

        byte [] secretMessage = person1.RSA_encrypt(message, person2.getPublicKey());

        System.out.println(secretMessage);

        String sendtBesked = person2.RSA_decrypt(secretMessage);

        System.out.println(sendtBesked); */

                int maxLength = 12; // Set the maximum length of the combinations
                Sha sha = new Sha();
                String secret = "hejsaemil";
                String secretHashed = sha.SHA_encrypt(secret);
                String resultat = "";
                LocalDateTime start = LocalDateTime.now();
                for (int length = 1; length <= 5; length++) {
                    resultat = bruteForce(secretHashed, length, sha);
                    if (resultat != null) {
                        break;
                    }
                }
                LocalDateTime slut = LocalDateTime.now();
                long diff = ChronoUnit.SECONDS.between(start,slut);
                System.out.println("Beskeden var:" + resultat  + "Det tog:" + diff + "Sekunder");


            }
        }

