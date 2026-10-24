import java.security.MessageDigest;

public class StringUtil
{

    /* Apply sha256 to a string and returns the result */

    public static String applySha256(String input)
    {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply Hashing algorithm to our input

            /* byte is a data type that occupies 8 bits (1 byte) and store values from -128 to 127 */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            StringBuffer hexString = new StringBuffer(); /* This will contain hash as hexidecimal */

            for(int i = 0; i < hash.length; i++)
            {
                String hex = Integer.toHexString(0xff & hash[i]);

                if(hex.length() == 1) hexString.append('0');

                hexString.append(hex);
            }

            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String calculateHash()
    {
        String calculatedHash = StringUtil.applySha256(

            previousHash + long.toString(timeStamp) +
            data
        );

        return  calculatedHash;
    }
}