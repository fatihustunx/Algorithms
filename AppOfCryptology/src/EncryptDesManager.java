import java.util.ArrayList;
import java.util.List;

public class EncryptDesManager {

	private int[] expansionPerm = {32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,
			16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
	
	private int[] pBoxPerm = {16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,
			2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
	
	public String Encrypt(String txt, List<String> keys) {
		
		String encryptTxt = Run(txt,keys);
		
		return Utilities.binaryToString(encryptTxt);
	}
	
	public String Decrypt(String txt, List<String> keys) {
		
		keys = keys.reversed();
		
		String resText = Run(txt, keys);
		
		return Utilities.binaryToString(resText);
	}
	
	private String Run(String txt, List<String> keys) {
		
		String cipherText ="";
		
		txt = Utilities.stringToBinary(txt);
		
		List<String> sOf64BitBlocks = sOf64Bit(txt);
		
		for (String sOf64BitBlock : sOf64BitBlocks) {
			for (int i = 0; i < keys.size(); i++) {
				
				String key = keys.get(i);
				
				sOf64BitBlock = forOfFunc(sOf64BitBlock, key);
				
				if(i+1==keys.size()) {
					String leftBlock = sOf64BitBlock.substring(0, 32);
					String rightBlock = sOf64BitBlock.substring(32, 64);
					sOf64BitBlock = rightBlock + leftBlock;
				}
			}
			
			cipherText+=sOf64BitBlock;
		}
		
		return cipherText;
	}
	
	private String forOfFunc(String block, String key) {
		String leftBlock = block.substring(0, 32);
		String rightBlock = block.substring(32, 64);
		
		String newLeftBlock = rightBlock;
		
		// Start F func.
		rightBlock = expansionPerm(rightBlock);
		
		rightBlock = xOR(rightBlock, key);
		
		rightBlock = sBox(rightBlock);
		
		rightBlock = pBoxPerm(rightBlock);
		// End F func.
		
		String newRightBlock = xOR(leftBlock, rightBlock);
		
		String newBlock = newLeftBlock + newRightBlock;
		
		return newBlock;
	}
	
	private static String sBox(String block) {	
		List<String> sBlocks = new ArrayList<>();
		
		int sLen = 6;
		
		for (int i = 0; i < block.length(); i+=sLen) {
			String newSBlock = block.substring(i,i+sLen);
			sBlocks.add(newSBlock);  // addFirst !
		}
		
		char[] rows=new char[2];
		char[] cols=new char[4];
		
		String to32BitBlock = "";
		
		List<int[][]> sBoxes = SBoxes.sBoxesList;
		
		for (int i =0; i<8;i++) {
			String sBlock = sBlocks.get(i);
			char[] sCharBlock = sBlock.toCharArray();
			rows[0]=sCharBlock[0];
			rows[1]=sCharBlock[5];
			
			cols[0]=sCharBlock[1];
			cols[1]=sCharBlock[2];
			cols[2]=sCharBlock[3];
			cols[3]=sCharBlock[4];
			
			int row = Utilities.bitToInt(Utilities.charsToString(rows));
			int col = Utilities.bitToInt(Utilities.charsToString(cols));
			
			int[][] sBox = sBoxes.get(i);
			
			int val = sBox[row][col];
			
			String resultOfSBox = Utilities.intToBit(val);
			
			while(resultOfSBox.length()!=4) {
				resultOfSBox = "0" + resultOfSBox;
			}
			
			to32BitBlock += resultOfSBox;
		}
		
		return to32BitBlock;
	}
	
	private String expansionPerm(String rightBlock) {
		char[] newRightBlock = new char[48];
		char[] charsOfBlock = rightBlock.toCharArray();
		for (int i = 0; i < newRightBlock.length; i++) {
			newRightBlock[i] = charsOfBlock[expansionPerm[i]-1];
		}
		
		return Utilities.charsToString(newRightBlock);
	}
	
	private String pBoxPerm(String rightBlock) {
		char[] newRightBlock = new char[32];
		char[] charsOfBlock = rightBlock.toCharArray();
		for (int i = 0; i < newRightBlock.length; i++) {
			newRightBlock[i] = charsOfBlock[pBoxPerm[i]-1];
		}
		
		return Utilities.charsToString(newRightBlock);
	}
	
	private String xOR (String s1, String s2) {
		
		int len = s1.length();
		
		char[] s1Chars = s1.toCharArray();
		char[] s2Chars = s2.toCharArray();
		
		char[] xOr = new char[len];
		
		for (int i = 0; i < len; i++) {
			if(s1Chars[i]!=s2Chars[i]) {
				xOr[i]='1';
			}else {
				xOr[i]='0';
			}
		}
		
		return Utilities.charsToString(xOr);
	}
	
	private static List<String> sOf64Bit(String bytes){
		List<String> listOf64BitBlocks = new ArrayList<>();
		
		int len = 0;
		
		if(bytes.length()%64!=0) {
			len = 64 - bytes.length()%64;
		}
		
		for(int i =0; i<len;i++) {
			bytes += '0';
		}
		
		int blockLength = 64;
		
		for (int i = 0; i < bytes.length(); i += blockLength) {
		    String block = bytes.substring(i, i+blockLength);
		    listOf64BitBlocks.add(block);
		}
		
		return listOf64BitBlocks;
	}
}