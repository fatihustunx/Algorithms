import java.math.BigInteger;

public class Utilities {

	public static String charsToString(char[] chars) {
		String s="";
		for (char c : chars) {
			s+=c;
		}
		return s;
	}
	
	public static int bitToInt(String s) {
		int total=0;
		
		char[] array = s.toCharArray();
		
		for (int i = array.length; i > 0; i--) {
			if(array[i-1]=='1') {
				total+=Math.pow(2, array.length-i);
			}
		}
		
		return total;
	}
	
	public static String intToBit(int s) {
		StringBuilder stringBuilder = new StringBuilder();
		
		int kalan=0;
		
		do {
			
			kalan=s%2;
			
			stringBuilder.append(kalan);
			
			s=s/2;
			
		}while(s>0);
		
		stringBuilder.reverse();
		
		return stringBuilder.toString();
	}
	
	public static String stringToBinary(String text) {
        StringBuilder binary = new StringBuilder();
        
        for (char character : text.toCharArray()) {
            int value = character;
            String binaryChar = Integer.toBinaryString(value);
            binary.append(String.format("%8s", binaryChar).replaceAll(" ", "0"));
        }
        return binary.toString();
    }
	
	public static String binaryToString(String binary) {
        StringBuilder text = new StringBuilder();
        
        int length = binary.length();

        for (int i = 0; i < length; i += 8) {
            String byteString = binary.substring(i, i + 8);
            int byteValue = Integer.parseInt(byteString, 2);
            text.append((char) byteValue);
        }

        return text.toString();
    }
	
	public static String intToBit2(BigInteger s) {
		StringBuilder stringBuilder = new StringBuilder();
		
		BigInteger kalan=BigInteger.valueOf(0);
		
		do {
			
			kalan=s.mod(BigInteger.valueOf(2));
			
			stringBuilder.append(kalan);
			
			s=s.divide(BigInteger.valueOf(2));
			
		}while(s.compareTo(BigInteger.ZERO)>0);
		
		stringBuilder.reverse();
		
		return stringBuilder.toString();
	}
}