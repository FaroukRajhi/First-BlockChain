# Setting Up

We will be using Java but you should be able to follow along in any OOP language.

# BlockChain

blockchain is just a chain/list of blocks. Each block in the blockchain will have its own digital fingerprint, contain digital fingerprint of the previous block, and have some data ( this data could be transactions for example ).
Hash = Digital Fingerprint.

Each block doesn’t just contain the hash of the block before it, but its own hash is in part, calculated from the previous hash. 

# How a digital signature works
Suppose Alice wants to send Bob 10 coins.
1. Alice's wallet constructs the transaction.
2. Her wallet signs the transaction using her private key.
3. Alice broadcasts the transaction and signature.
4. Nodes verify the signature using the relevant public key or account authorization rules.
5. Nodes also check other rules, such as whether Alice has sufficient funds and whether the transaction is valid for the current blockchain state
