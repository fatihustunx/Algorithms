public class Level2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Girilen saydan büyük en küçük ve asal fib sayısı bulunur.
		int res = fib(227000);
		
		System.out.println("\n Resault : " + res);
		
		// Bu sayının bir fazlasının asal bölenlerinin toplamları bulunur.
		int sum = sumOfPrimeDivisors(res+1);
		
		System.out.println("\n Sum of prime divisors : " + sum);
	}
	
	// Parametre olarak girilen sayıdan büyük en küçük asal fibonacci sayısını bulur.
	public static int fib(int val) {
		// fibin ilk sayısı
		int a = 1;
		// fibin ikinci sayısı
		int b = 1;

		// a+b yi tutucak değer
		int res=0;
		
		// Eğer fib sayısı girilen değerden küçük ve asal değil ise döngüye devam et
		while(res<val || !isPrime(res)) {
			// fib1 ve fib2 toplanır yeni fib sayısı elde edilir.
			res = a + b;
			
			// fib2 sayısı fib1'e aktarılır
			a = b;
			// fib2 sayısı ise toplam değer olur.
			b = res;
		}
		
		// Bulunan sonuç geri dönülür.
		return res;
	}
	
	// Parametre olarak girilen sayının asal bölenlerini toplar
	public static int sumOfPrimeDivisors(int val) {
		int sum =0;
		
		// Sayının yarına kadar olacak şekilde döngü oluşturulur.
		// Sayının kendisi kadar döngü oluşturmak bir şey ifade etmez.
		for(int i=2;i<=val/2;i++) {
			// Eğer i değeri girilen sayıyı tam bölüyor ve asal ise toplanır.
			if(val%i==0 && isPrime(i)) {
				sum+=i;
			}
		}
		// Toplam değer geri dönülür.
		return sum;
	}
	
	// Parametre olarak girilen sayı asal mı ?
	public static boolean isPrime(int val) {	
		// Sayının kare köküne kadar döngü oluşturulur.
		// Bir sayının asal mı olduğunu kontrol etmek için en kısa adım
		// -> o sayının kare kökünü alana kadar devam etmektir.
		for(int i=2;i<=Math.sqrt(val);i++) {
			// Eğer sayıyı bu aralıkta farklı bir değer tam bölerse sayı asal değildir.
			if(val%i==0) {
				return false;
			}
		}
		// Sonuç geri dönülür.
		return true;
	}
}