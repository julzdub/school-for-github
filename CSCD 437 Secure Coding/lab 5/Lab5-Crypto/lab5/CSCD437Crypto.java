package lab5;
import java.io.*;
import java.security.*;
import java.util.Scanner;
import javax.crypto.*;

public class CSCD437Crypto {

	private KeyPairGenerator keyPairGen; //A KeyPairGenerator for generating public/private keys named keyPairGen
	private KeyPair pair; //The combined KeyPair named pair
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private Signature sign;

	public CSCD437Crypto​(String signatureAlgo, String keyPairAlgo, int keySize) {
		generateKeys​(signatureAlgo, keyPairAlgo, keySize);
	}

	//This method allows a user to generate a new public/private key and new signature.

	public void	generateKeys​(String signatureAlgo, String keyPairAlgo, int keySize)	{
		
		try {

			this.sign = new Signature(signatureAlgo);
			this.keyPairGen = new KeyPairGenerator(keyPairAlgo);
			this.keyPairGen.initialize(keySize);
			this.pair = this.keyPairGen.generateKeyPair();
			this.privateKey = this.pair.getPrivate();
			this.publicKey = this.pair.getPublic();
		}

		catch(NoSuchAlgorithmException e) {
			System.out.print(e.message);
		}
		
	}


	// The decrypt method decrypts the message by using your private key.

	public void	decrypt​(String filename, String transformation)	{

	}


	//The encrypt method is overloaded to allow for a text file to be passed in.

	public void	encrypt​(PublicKey publicKey, String transformation, File messageFile, String encryptedFilename)	{

	}


	//The encrypt method uses the message receiver's public key and the transformation string to encrypt the message to produce and encrypted file.

	public void	encrypt​(PublicKey publicKey, String transformation, String message, String encryptedFilename) {

	}
	

	//This method reads the public key from the file where the public key was published.

	public static PublicKey	getPublicKey​(String filename) {

	}
	
	
	//This method publishes the public key into a ObjectOutputStream file.

	public void	publishPublicKey​(String filename) {
		
	}

}