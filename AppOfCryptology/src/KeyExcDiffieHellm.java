import java.math.BigInteger;
import java.util.Random;

public class KeyExcDiffieHellm {

	private static BigInteger p = BigInteger.probablePrime(64, new Random());
	
	private static BigInteger g = BigInteger.valueOf(7);
	
	public static void Run(User userA, User userB) {
		
		// Ali excKeyDiff
		BigInteger userAKey = KeyExcDiffieHellm.excKey(userA);
		// Veli excKeyDiff
		BigInteger userBKey = KeyExcDiffieHellm.excKey(userB);
				
		// Ali excKey2
		BigInteger userAKey2 = KeyExcDiffieHellm.excKey2(userA, userBKey);
		// Veli excKey2
		BigInteger userBKey2 = KeyExcDiffieHellm.excKey2(userB, userAKey);
		
		// Exc Encrypt Keys
		userA.setEncryptKey(toKey64Bit(userBKey2));
		userB.setEncryptKey(toKey64Bit(userAKey2));
		
		// Exc Signing Public Keys
		userA.setPublicKey(userB.getSignKeys().getPublic());
		userB.setPublicKey(userA.getSignKeys().getPublic());
		
			System.out.println("	"
				+ "<-- Encrypt Keys & Signing Public Keys Exc... -->");
	}
	
	private static BigInteger excKey(User user) {
		
		BigInteger key = g.modPow(user.getExcKeyDiff(), p);
		
		return key;
	}
	
	private static BigInteger excKey2(User user, BigInteger key) {
		
		BigInteger key2 = key.modPow(user.getExcKeyDiff(), p);
		
		return key2;
	}
	
	private static String toKey64Bit(BigInteger key) {
		StringBuilder st = new StringBuilder();
		String s = Utilities.intToBit2(key);
		st.append(s);
		while(true) {
			if(st.length()!=64) {
				st.append("0");
			}else if(st.length()==64) {
				break;
			}
		}
		return st.toString();
	}
}
