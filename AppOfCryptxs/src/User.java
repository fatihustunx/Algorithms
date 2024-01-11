import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PublicKey;

public class User {
	
	private BigInteger excKeyDiff;

	private String encryptKey;
	
	private KeyPair signKeys;
	
	private PublicKey publicKey;
	
	private String app;
	
	public User() throws Exception {
		this.excKeyDiff = new BigInteger
				(64, new java.security.SecureRandom());
		this.signKeys = SignManager.generateECKeyPair();
	}

	public BigInteger getExcKeyDiff() {
		return excKeyDiff;
	}

	public void setExcKeyDiff(BigInteger excKeyDiff) {
		this.excKeyDiff = excKeyDiff;
	}

	public String getEncryptKey() {
		return encryptKey;
	}

	public void setEncryptKey(String desKey) {
		this.encryptKey = desKey;
	}

	public KeyPair getSignKeys() {
		return signKeys;
	}

	public void setSignKeys(KeyPair signKeys) {
		this.signKeys = signKeys;
	}
	
	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
}