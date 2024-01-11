import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MacManager {
	
	private static final String HMAC_SHA512 = "HmacSHA512";

	public byte[] Run(String txt, String key) {

		 Mac sha512Hmac;
	     byte[] res = null;

	        try {
	            final byte[] byteKey = key.getBytes();
	            sha512Hmac = Mac.getInstance(HMAC_SHA512);
	            SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
	            sha512Hmac.init(keySpec);
	            byte[] macData = sha512Hmac.doFinal(txt.getBytes());
	            // Can either base64 encode or put it right into hex
	            //res = Base64.getEncoder().encodeToString(macData);
	            
	            return macData;
	            
	            //result = bytesToHex(macData);
	        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        
	        return res;
	}
}