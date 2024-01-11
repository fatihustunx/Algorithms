import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level3{
	
	public static void main(String[] args) {
		
		//int[] array = {1,2,3,4,6};
		int[] array = {3,4,9,14,15,19,28,37,47,50,54,56,59,61,70,73,78,81,92,95,97,99};
		
		// Bütün alt kümeleri barındıran bir liste oluşturulur.
		List<List<Integer>> subsets = new ArrayList<>();
		
		// Array'in uzunluğu alınır.
		int len = array.length;
		
		// 2^len kadar bir döngü oluşturulur.
		// 2^len bir kümenin alt küme sayısını temsil eder.
		for(int i=0;i<Math.pow(2, len);i++) {
			// Her alt küme için bir integer list oluşturulur.
			List<Integer> sub = new ArrayList<>();
			// Bitlerin konumuna göre alt kümeeler oluşturmak için
			// i'ler her döngüde String bitlere çevirlir. -> "001"
			String bits = intToBit(i,len);
			// Array'deki elemanı almak için bir index oluşturulur.
			int index = 0;
			// Bitler sırası ile gezilir.
			for(char c : bits.toCharArray()) {
				// Eğer bitler de 1 e eşit olan var ise
				// Array'in ilgili index'indeki eleman listeye eklenir.
				if(c=='1') {
					sub.add(array[index]);
				}
				index++;
			}
			// Döngü sonunda bir alt küme oluşmuş olur.
			// Ve alt kümeleri tutan listeye eklenir.
			subsets.add(sub);
		}
		
		int answer = 0;
		System.out.println("\n Subsets->\n");
		
		// Her alt küme gezilir.
		for (List<Integer> list : subsets) {
			// Sıralanır.
			Collections.sort(list);
			if(!list.isEmpty()) {
				// Alt kümedeki max değer alınır.
				int max = list.get(list.size()-1);
				
				int sum = 0;
				// Bir alt kümedeki her eleman toplanır.
				for (Integer s : list) {
					sum += s;
				}
				// Ve max değer çıkarılır ki karşılaştırma yapılsın.
				sum = sum - max;
				// Eğer alt kümedeki max eleman diğer elemanların toplamına eşit ise
				// Answer yani cevap olan alt küme sayısı 1 arttırılır.
				if(sum==max) {
					System.out.println(list);
					answer++;
				}
			}
		}
		
		System.out.println("\n Answer -> " + answer);
	}
	
	// Bir kümenin alt kümelerini bulmak için binary sistemden yararlandım.
	// Bunun için bir int'i bitlere çeviren örneğin "001" bir fonksiyon...
	public static String intToBit(int s, int len) {
		StringBuilder stringBuilder = new StringBuilder();
		
		int kalan=0;
		
		do {
			
			kalan=s%2;
			
			stringBuilder.append(kalan);
			
			s=s/2;
			
		}while(s>0);
		
		// Bitler dizinin boyutundaki index'e göre elemanları temsil edeceği için
		// çevirilen değer dizi boyutundan küçük ise sonuna 0 ekliyorum.
		while(stringBuilder.length()!=len) {
			stringBuilder.append(0);
		}
		
		stringBuilder.reverse();
		
		return stringBuilder.toString();
	}
}