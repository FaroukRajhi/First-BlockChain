import java.util.Date;

public class Block
{
    public String hash;
    public String previousHash;

    /* Our data that will be a simple message or transaction */
    private String data; 

    /* As number of milliseconds since 1/1/1970 (UNIX Timestamp) */
    private long timeStamp;


    /* Block Constructor */

    public Block(String data, String previousHash)
    {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }
}