package com.eccweb.crypto;

import java.security.KeyPair;
import java.security.Security;

import javax.crypto.SecretKey;

public class TestECC {
//	  public static void main(String[] args) {
//	    	
//	    	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//	    	
//	        String plainText = "{\"rid\":1,\"machine\":\"CNC\",\"powerConception\":\"vvv\",\"noOfWorkers\":4,\"noOfJobs\":3,\"serviceEngineer\":\"444\",\"$promise\":{},\"$resolved\":true}";
//	        System.out.println("Original plaintext message: " + plainText);
//
//	        // Initialize two key pairs
//	        PairKey keyPairA = ECCUtil.generateECKeys();
//	        PairKey keyPairB = ECCUtil.generateECKeys();
//
//	        // Create two AES secret keys to encrypt/decrypt the message
//	        String secretKeyA = ECCUtil.generateSharedSecret(keyPairA.getPrivateKey(),
//	                keyPairB.getPublicKey());
//	        String secretKeyB = ECCUtil.generateSharedSecret(keyPairB.getPrivateKey(),
//	                keyPairA.getPublicKey());
//
//	        // Encrypt the message using 'secretKeyA'
//	        String cipherText = ECCUtil.encryptString(secretKeyA, plainText);
//	        System.out.println("Encrypted cipher text: " + cipherText);
//
//	        // Decrypt the message using 'secretKeyB'
//	        String decryptedPlainText = ECCUtil.decryptString(secretKeyB, cipherText);
//	        System.out.println("Decrypted cipher text: " + decryptedPlainText);
//	    }
}
