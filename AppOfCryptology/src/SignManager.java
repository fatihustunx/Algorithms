import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

public class SignManager {

	public static KeyPair generateECKeyPair() throws Exception {
	    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
	    ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");
	    keyGen.initialize(ecSpec, new SecureRandom());
	    return keyGen.generateKeyPair();
	}
	
	public byte[] signDataECDSA(byte[] txt, PrivateKey privateKey) throws Exception {
		//byte[] data = txt.getBytes();
	    Signature ecdsaSign = Signature
	    		.getInstance("SHA256withECDSA");
	    ecdsaSign.initSign(privateKey);
	    ecdsaSign.update(txt);
	    //return new String(ecdsaSign.sign());
	    return ecdsaSign.sign();
	}
	
	public boolean verifySignatureECDSA(byte[] txt, byte[] signTxt, PublicKey publicKey) throws Exception {
		//byte[] data = txt.getBytes();
		//byte[] sign = signTxt.getBytes();
 	    Signature ecdsaVerify = Signature
 	    		.getInstance("SHA256withECDSA");
	    ecdsaVerify.initVerify(publicKey);
	    ecdsaVerify.update(txt);
	    return ecdsaVerify.verify(signTxt);
	}
}