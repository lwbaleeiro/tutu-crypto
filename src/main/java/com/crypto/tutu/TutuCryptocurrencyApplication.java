package com.crypto.tutu;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class TutuCryptocurrencyApplication {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;

	public static void main(String[] args) {

		System.out.println("Trying to mine block 1...");
		addBlock(new Block("Hello, Im the first block", "0"));

		System.out.println("Trying to mine block 2...");
		addBlock(new Block("This is the second block!", blockchain.get(blockchain.size()-1).hash));

		System.out.println("Trying to mine block 3...");
		addBlock(new Block("The third block is here.", blockchain.get(blockchain.size()-1).hash));

		System.out.println("\nBlockchain is valid: " + isChainValid());

		String blockchainJson = StringUtil.getJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace("\0", "0");

		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);

			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal!");

				return false;
			}

			if (!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous Hashes not equal!");

				return false;
			}

			if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined!");

				return false;
			}
		}

		return true;
	}


	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
}
