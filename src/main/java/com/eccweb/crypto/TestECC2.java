package com.eccweb.crypto;

import java.security.KeyPair;
import java.security.Security;

import javax.crypto.SecretKey;

public class TestECC2 {
//	  public static void main(String[] args) {
//	    	
//	    	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//	    	
//	        String plainText = "{\"rid\":1,\"machine\":\"CNC\",\"powerConception\":\"vvv\",\"noOfWorkers\":4,\"noOfJobs\":3,\"serviceEngineer\":\"444\",\"$promise\":{},\"$resolved\":true}";
//	        System.out.println("Original plaintext message: " + plainText);
//
//	        // Initialize two key pairs
////	        PairKey keyPairA = ECCUtil.generateECKeys();
////	        PairKey keyPairB = ECCUtil.generateECKeys();
//
//	        PairKey keyPairA = new PairKey();
//	        keyPairA.setPrivateKey("30820109020100301006072A8648CE3D020106052B810400270481F13081EE02010104480342C0A0256CC83D13591289A6AA0252EC9C3EFEFA4D7FBBE6CDDEFAE96AA528CD728E919D6692436EBAEC3533FA24DDA01B7EC0DD240F127E3380F594387776DC592875CFDA71FBA00706052B81040027A18195038192000405238552025611AC24F75E999A672CB5630506ECC71782F30AF32EB79CCF5FEFD38A11B20503FD57708470B16EEB41A447DA2ABA1A097CE7DFDFDB33AD8754B0AB178CDE6EE86C94044729C8A353DF92F082A94CDD038BE2CF1517E40AB76DBD10D408283D04642164F2A28486E94CE0387C6AF1D47151C44DF2826EBC9AA62D13C7C9FBADD374063CCF2BE7C838D90E");
//	        keyPairA.setPublicKey("3081A7301006072A8648CE3D020106052B81040027038192000405238552025611AC24F75E999A672CB5630506ECC71782F30AF32EB79CCF5FEFD38A11B20503FD57708470B16EEB41A447DA2ABA1A097CE7DFDFDB33AD8754B0AB178CDE6EE86C94044729C8A353DF92F082A94CDD038BE2CF1517E40AB76DBD10D408283D04642164F2A28486E94CE0387C6AF1D47151C44DF2826EBC9AA62D13C7C9FBADD374063CCF2BE7C838D90E");
//	        
//	        PairKey keyPairB = new PairKey();
//	        keyPairB.setPrivateKey("30820109020100301006072A8648CE3D020106052B810400270481F13081EE020101044803B452F56F5F0BBD350989E3A196D42CEF62C78AFE197DD3AD074A43D84F7DBDCF80868BD88CF9E0CBE10843CD8C2A4890656D034ECE16A7A715D23D26C48EB433506BB86B73AFA3A00706052B81040027A18195038192000404802E2154B7C0E779061BE7AAB932C6B15B747D10AFECDC975E8B603BB474D14CC9135277689B654177908234E0DC66BFFF02040A297D49BF89C5B1DECFD3B1C29E5294DFC376AB0263305620D4BCE6491AEF61788698C2AE432BD15F1EEC3F84A80F86CAB85F5737DD6C786EF1AD7765E481B4FFA13247936AD04E248FC6719DF25E24FE8327D762086F137B190D81");
//	        keyPairB.setPublicKey("3081A7301006072A8648CE3D020106052B81040027038192000404802E2154B7C0E779061BE7AAB932C6B15B747D10AFECDC975E8B603BB474D14CC9135277689B654177908234E0DC66BFFF02040A297D49BF89C5B1DECFD3B1C29E5294DFC376AB0263305620D4BCE6491AEF61788698C2AE432BD15F1EEC3F84A80F86CAB85F5737DD6C786EF1AD7765E481B4FFA13247936AD04E248FC6719DF25E24FE8327D762086F137B190D81");
//	        
//	        System.out.println("PrivateKeyA:"+keyPairA.getPrivateKey());
//	        System.out.println("PublicKeyA:"+keyPairA.getPublicKey());
//	        System.out.println("PrivateKeyB:"+keyPairB.getPrivateKey());
//	        System.out.println("PublicKeyB:"+keyPairB.getPublicKey());
//
//	        // Create two AES secret keys to encrypt/decrypt the message
//	        String secretKeyA = ECCUtil.generateSharedSecret(keyPairA.getPrivateKey(),
//	                keyPairB.getPublicKey());
//	        String secretKeyB = ECCUtil.generateSharedSecret(keyPairB.getPrivateKey(),
//	                keyPairA.getPublicKey());
//	        
//	        System.out.println("SecretKeyA:"+secretKeyA);
//	        System.out.println("SecretKeyB:"+secretKeyB);
//	        
//	        if(secretKeyA.equals(secretKeyB)){
//	        	System.out.println("Seecret key A and B are equal");
//	        }
//	        // Encrypt the message using 'secretKeyA'
//	        String cipherText = ECCUtil.encryptString(secretKeyA, plainText);
//	        System.out.println("Encrypted cipher text:" + cipherText);
////	        String cipherText1 = "B625C18D09A63C3FF7D0118BD1A6F64F6B490F08EA53833BB9AB3ABB0442A30EC53FC9F637C4B553E398A1E3CF5C64178F52BDEEC2C4B13EEBBBBCD9B8F7F75F2ED7D86D5E2D1914F158CAA0D1FE30FB719A9016B6922B4C47B0BE065CA63EF606A260148267CCFEE2A3597B833DBE1BF4E154AA6431BC5FFB2427945665E3926DD05FA77E42A912D019D9C572067249B762BE62BC";
////	        String secretKeyB1 = "076FCDB9536C779D0E0594A2980989C1EDE8024AD8C696E64C6B3023555E8EF8";
////	        
////	        if(cipherText1.equals(cipherText)){
////	        	System.out.println("CIpher text is equal");
////	        }
//	        
////	        if(secretKeyB1.equals(secretKeyB)){
////	        	System.out.println("Secret key is equal");
////	        }
//	        // Decrypt the message using 'secretKeyB'
//	        String decryptedPlainText = ECCUtil.decryptString(secretKeyB, cipherText);
//	        System.out.println("Decrypted cipher text:" + decryptedPlainText);
//	    }
}
