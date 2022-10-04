/**
 * 
 */
package lab5;
import java.io.*;
import java.security.*;
import javax.crypto.*;

/**
 * @Author Ryan Cranston
 * @Purpose For CSCD437 
 */
public class CSCD437Crypto 
{
	private Signature sign;
	private KeyPairGenerator keyPairGen;
	private KeyPair pair;
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	CSCD437Crypto(String signatureAlgo, String keyPairAlgo, int keySize)
	{
		generateKeys(signatureAlgo,keyPairAlgo,keySize);
	}

	public void generateKeys(String signatureAlgo, String keyPairAlgo, int keySize)
	{
		try 
		{
			sign=Signature.getInstance(signatureAlgo);
			keyPairGen= KeyPairGenerator.getInstance(keyPairAlgo);
			keyPairGen.initialize(keySize);
			pair=keyPairGen.genKeyPair();
			publicKey=pair.getPublic();
			privateKey=pair.getPrivate();
			
		} 
		catch (NoSuchAlgorithmException e) 
		{e.printStackTrace();}

	}
	public void publishPublicKey​(String filename) throws IOException
	{
		try 
		{
			FileOutputStream FOS= new FileOutputStream(filename);
			ObjectOutputStream OOS = new ObjectOutputStream(FOS);
			OOS.writeObject(this.publicKey);
			OOS.close();
			FOS.close();
		} 
		catch (FileNotFoundException e) 
		{e.printStackTrace();}
	}
	public static PublicKey getPublicKey​(String filename) throws ClassNotFoundException
	{
		try 
		{
			FileInputStream FIS= new FileInputStream(filename);
			ObjectInputStream OIS = new ObjectInputStream(FIS);
			PublicKey Pkey=(PublicKey) OIS.readObject();
			OIS.close();
			FIS.close();
			return Pkey;
		} 
		catch (IOException e) 
		{e.printStackTrace();}
		return null;
	}
	public void encrypt​(PublicKey publicKey, String transformation, String message, String encryptedFilename)
	{
		try 
		{
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] input = message.getBytes();	  
			cipher.update(input);
			byte[] cipherText = cipher.doFinal();
			FileOutputStream FOS= new FileOutputStream(encryptedFilename);
			ObjectOutputStream OOS = new ObjectOutputStream(FOS);
			OOS.writeObject(cipherText);
			OOS.close();
			FOS.close();
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException e) 
		{e.printStackTrace();}
	}
	public void encrypt​(PublicKey publicKey, String transformation, File messageFile, String encryptedFilename)
	{
		try 
		{
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] input = messageFile.toString().getBytes();	  
			cipher.update(input);
			byte[] cipherText = cipher.doFinal();
			FileOutputStream FOS= new FileOutputStream(encryptedFilename);
			ObjectOutputStream OOS = new ObjectOutputStream(FOS);
			OOS.writeObject(cipherText);
			OOS.close();
			FOS.close();
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException e) 
		{e.printStackTrace();}		
	}
	public void decrypt​(String filename, String transformation)
	{
		try 
		{
			FileInputStream FIS= new FileInputStream(filename);
			ObjectInputStream OIS = new ObjectInputStream(FIS);
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] cipherText=(byte[]) OIS.readObject();
			byte[] decipheredText = cipher.doFinal(cipherText);
			System.out.println(new String(decipheredText));
			OIS.close();
			FIS.close();
		} 
		catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | ClassNotFoundException | IllegalBlockSizeException | BadPaddingException e) 
		{e.printStackTrace();}
	}
}
