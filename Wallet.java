/* We will create a wallet class to hold our public key and private keys */

package Main;

import java.security;

public class Wallet {


    public void generateKeyPair()
    {
        try
        {
            /*  Elliptic-curve cryptography to Generate our KeyPairs. */
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// Initialize the key generator and generate a KeyPair
			keyGen.initialize(ecSpec, random);   //256 bytes provides an acceptable security level
	        KeyPair keyPair = keyGen.generateKeyPair();
	        // Set the public and private keys from the keyPair
	        privateKey = keyPair.getPrivate();
	        publicKey = keyPair.getPublic();
        }catch(Execption e )
        {
            throw new RuntimeException(e);
        }
    }

    /*
    For our Main the public key will act as our address.
    We will share public key with others to receive payment.
    Our private key is used to sign our transactions.
     */

    public PrivateKey privateKey;
    public PublicKey publicKey;


}