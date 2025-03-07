# Tutu Cryptocurrency

This is a project based on the tutorial by [Kass](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa).

The aim of this project is to help me understand blockchain technology by developing one.

In this project I will:
- Create very basic ‘blockchain’.
- Implement a simple proof of work ( mining ) system.

It’s worth noting that this wont be a fully functioning, ready for production block chain. \
Instead this is a proof of concept implementation to help me understand what a blockchain is.

## **Making the Blockchain.**

A blockchain is just a chain/list of blocks. Each block in the blockchain will have its own digital fingerprint of the previous block, and have some data (this data could be transactions for example).

![img.png](img.png)

## **Hash = Digital fingerprint**

**Each block doesn't just contain the hash of the block before it, but its own hash is in part, calculated form the previous hash.**
If the previous block's data is changed then the previous block's hash will change (since it is calculated in part, by the data) in turn affecting all the hashes of the blocks thereafter.
**Calculating and comparing the hashes allow us to see if a blockchain is valid.**

What does this mean? ... Changing any data in this list, will change the signature and break the chain.
