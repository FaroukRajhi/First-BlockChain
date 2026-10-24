
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class StringUtil {

    /*
     * Apply SHA-256 to a string and return the result
     * as a hexadecimal string.
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the input string into bytes and hash them.
            byte[] hash = digest.digest(
                input.getBytes(StandardCharsets.UTF_8)
            );

            // Convert the hash bytes into a hexadecimal string.
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);

                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error calculating SHA-256 hash", e);
        }
    }

    /*
     * Calculate a block's hash using its previous hash,
     * timestamp, and data.
     */
    public static String calculateHash(
            String previousHash,
            long timeStamp,
            String data) {

        return applySha256(previousHash + timeStamp + data);
    }
}
