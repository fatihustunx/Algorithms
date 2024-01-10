public class SendObject {

	private String encryptTxt;
	private byte[] signingTxt;
	
	public String getEncryptTxt() {
		return encryptTxt;
	}
	public void setEncryptTxt(String encryptTxt) {
		this.encryptTxt = encryptTxt;
	}
	public byte[] getSigningTxt() {
		return signingTxt;
	}
	public void setSigningTxt(byte[] signingTxt) {
		this.signingTxt = signingTxt;
	}
}