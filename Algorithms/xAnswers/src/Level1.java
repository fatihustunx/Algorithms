import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String text ="I like racecars that go fast";
		String text ="FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequal"
				+ "NowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwar"
				+ "WehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthat"
				+ "weshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconse"
				+ "crateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisfor"
				+ "usthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreat"
				+ "tdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighly"
				+ "resolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		
		// Text char array'e dönüştürülür.
		char[] chars = text.toCharArray();

		// char arrayin uzunluğu alınır.
		int len = chars.length;
		
		// Bulunan kelime tam olarak tersi ile eşleşiyor mu
		// Sebebi ile kontrol ifadesi tanımlanır.
		boolean control;
		
		// Tersi ile eşleşen char'ları bir stringe atamak için kullanılır.
		StringBuilder stringBuilder = new StringBuilder();
		
		// Text'teki tersi ile eşleşen kelimeleri bir string listesine atamak için..
		List<StringBuilder> listOfString = new ArrayList<>();
		
		// Textin ilk harfinden başlar.
		for(int i=0;i<len;i++) {
			// Textin son harfinden başlar
			// i'ye kadar bir döngü oluşturulur.
			for(int j=len-1;j>=i;j--) {
				// Her harf karşılaştırılır
				if(chars[i]==chars[j]) {
					// Karşılaştırılan harfler eşit ise bu harflerin arasındaki fark kadar bir döngü oluşturulur.
					// Bu döngüde ilk harf yani i'den başlanılarak j'den ise geriye doğru harfler karşılaştırılır.
					for(int k=0;k<=j-i;k++) {
						// Harfler döngünün başından ve sonundan başlayarak tek tek karşılaştırılır
						if(chars[i+k]==chars[j-k]) {
							// Eğer harfler eşit ise bir stringe atanır.
							stringBuilder.append(chars[i+k]);
						}else {
							// Eşit olmayana kadar devam eder ve döngüden çıkılır.
							break;
						}
					}
					control = true;
					// Karşılaştırılan harfler bir stringe atandıktan sonra tersi ile aynı mı diye kontrol edilir.
					// Çünkü alogritmamız da kelime tam olarak eşleşmeden örneğin yarısına kadar eşleyior ise de stringe atar.
					for(int c=0;c<stringBuilder.length();c++) {
						if(stringBuilder.charAt(c)!=stringBuilder.charAt(stringBuilder.length()-c-1)) {
							control=false;
						}
					}
					// Eğer tam olarak tersi ile eşleşiyor ise ve boyutu 2 den büyükse listeye eklenir.
					// 2 olmasının sebebi 2 ve daha küçük kelimelerin tersi ile aynı olması bir anlam ifade etmemesinden gelir.
					if(control && stringBuilder.length()>2) {
						listOfString.add(new StringBuilder(stringBuilder));
					}
					// Döngü sonunda string ifade sıfırlanır.
					// Ram de yer kaplamaması için new'lenmemiştir.
					stringBuilder.delete(0, stringBuilder.length());
				}
			}
		}

		// Kelimeler uzunluk olarak büyükten küçüğe sıralanır.
		Collections.sort(listOfString, (a,b)->{
			return b.length()-a.length();
		});
		
		// Text'teki tersi olan kelimelerin toplam sayısı ->
		System.out.println("\n" +"Total Words : " + listOfString.size() + "\n");
		
		// Tersi olan en uzun kelime cevap ->
		System.out.println("Answer : " + listOfString.get(0));
		
		System.out.println("\n * Other words \n");
		// Text de tersi olan diğer bütün kelimeler ->
		for (StringBuilder stringBuilder2 : listOfString) {
			System.out.println(stringBuilder2.toString());
		}
	}

}