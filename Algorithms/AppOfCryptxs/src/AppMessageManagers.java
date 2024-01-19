import java.util.ArrayList;
import java.util.List;

public class AppMessageManagers {

	private EncryptDesManager encryptDes;

	private MacManager macManager;
	private SignManager signManager;

	private KeyManager keyManager;

	public AppMessageManagers() {
		this.encryptDes = new EncryptDesManager();
		this.macManager = new MacManager();
		this.signManager = new SignManager();
		this.keyManager = new KeyManager();
	}

	public List<User> getUsers() throws Exception {

		User userA = new User();
		userA.setApp("Ali");

		User userB = new User();
		userB.setApp("Veli");

		KeyExcDiffieHellm.Run(userA, userB);

		List<User> users = new ArrayList<User>();

		users.add(userA);
		users.add(userB);

		return users;
	}

	public SendObject sendMsg(User user, String txt) throws Exception {

		List<String> keys = keyManager.Run(user.getEncryptKey());

		String encryptTxt = encryptDes.Encrypt(txt, keys);

		byte[] macTxt = macManager.Run(encryptTxt, user.getEncryptKey());
		byte[] signTxt = signManager.signDataECDSA(macTxt, user.getSignKeys().getPrivate());

		SendObject sendObj = new SendObject();
		sendObj.setEncryptTxt(encryptTxt);
		sendObj.setSigningTxt(signTxt);

		return sendObj;
	}

	public String getMsg(User user, SendObject sendObj) throws Exception {
		String encryptTxt = sendObj.getEncryptTxt();
		byte[] signTxt = sendObj.getSigningTxt();

		byte[] macTxt = macManager.Run(encryptTxt, user.getEncryptKey());
		boolean control = signManager.verifySignatureECDSA(macTxt, signTxt, user.getPublicKey());

		if (control) {
			List<String> keys;
			String res;
			keys = keyManager.Run(user.getEncryptKey());
			res = encryptDes.Decrypt(encryptTxt, keys);
			return res;
		} else {
			throw new Exception();
		}
	}
}
