
import java.util.ArrayList;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static int difficulty = 4;

    public static String hashTarget =
        new String(new char[difficulty]).replace('\0', '0');

    
public static boolean isChainValid() {

    if (blockchain.isEmpty()) {
        return false;
    }

    // Verify the first block
    Block firstBlock = blockchain.get(0);

    if (!firstBlock.hash.equals(firstBlock.calculateHash())) {
        System.out.println("First block hash is invalid");
        return false;
    }

    // Verify the remaining blocks
    for (int i = 1; i < blockchain.size(); i++) {

        Block currentBlock = blockchain.get(i);
        Block previousBlock = blockchain.get(i - 1);

        // Check the current block's hash
        if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
            System.out.println("Current Hashes not equal");
            return false;
        }

        // Check the link to the previous block
        if (!currentBlock.previousHash.equals(previousBlock.hash)) {
            System.out.println("Previous Hashes not equal");
            return false;
        }

        /* Check if hash is solved */
        if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
		}
    }

    return true;
}


    public static void main(String[] args) {

        // Create the blocks
        blockchain.add(new Block("Hi, I'm the first block", "0"));

        blockchain.add(new Block(
            "Yo, I'm the second block",
            blockchain.get(blockchain.size() - 1).hash
        ));

        blockchain.add(new Block(
            "Hey, I'm the third block",
            blockchain.get(blockchain.size() - 1).hash
        ));

        // Print the blockchain
        for (Block block : blockchain) {
            System.out.println(block);
        }

        // Validate the blockchain
        System.out.println("\nIs blockchain valid? " + isChainValid());
    }
}
