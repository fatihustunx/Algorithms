import java.util.ArrayList;
import java.util.List;

public class KeyManager {
	
	private List<String> keys;
	
	private int[] shiftBits = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
	
	private int[] keyPerm56 = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,
	                 63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
	
	private int[] keyPerm48 = {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,
			41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
 	
	public List<String> Run (String key){
		
		keys = new ArrayList<String>();
		
		key = Utilities.stringToBinary(key);
		
		key = toKey56Bit(key);
		
		String leftKey = key.substring(0,28);
		String rightKey = key.substring(28,56);
		
		for (int i = 0; i < shiftBits.length; i++) {
			for (int j = 0; j < shiftBits[i]; j++) {
				leftKey = shiftKey(leftKey);
				rightKey = shiftKey(rightKey);
			}
			key = leftKey + rightKey;
			key = toKey48Bit(key);
			keys.add(key);
		}
		
		return keys;
	}
	
	private String toKey48Bit(String key) {
		char[] newKey = new char[48];
		char[] keyChars = key.toCharArray();
		for (int i = 0; i < newKey.length; i++) {
			newKey[i]=keyChars[keyPerm48[i]-1];
			//newKey[48-i-1]=keyChars[56-keyPerm48[i]];
		}
		
		return Utilities.charsToString(newKey);
	}
	
	private String toKey56Bit(String key) {
		char[] newKey=new char[56];
		char[] keyChars = key.toCharArray();
		for (int i = 0; i < newKey.length; i++) {
			newKey[i]=keyChars[keyPerm56[i]-1];
			//newKey[56-i-1]=keyChars[64 - keyPerm56[i]];
		}
		
		return Utilities.charsToString(newKey);
	}
	
	private String shiftKey(String key) {
		char[] keyChars = key.toCharArray();
		
		char temp = keyChars[0];
		
		for (int i = 0; i < key.length(); i++) {
			if(i+1==key.length()) {
				keyChars[i]=temp;
				break;
			}
			keyChars[i] = keyChars[i+1];
		}
		
		return Utilities.charsToString(keyChars);
	}
}