import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		AppMessageManagers app = new AppMessageManagers();

		List<User> users = app.getUsers();

		String red = "\u001B[31m";
		String green = "\u001B[32m";
		String cyan = "\u001B[36m";
		
		boolean control=true;
		
		while(control) {
			
			User user = users.get(0);
			
			System.out.println();
			System.out.print(cyan + user.getApp() + " -> ");
	        String txt = scanner.nextLine();
	        
	        SendObject sendObj;
			
			sendObj = app.sendMsg(user, txt);
			
			System.out.println();
			System.out.println(red + "Encrypt Txt : " + sendObj.getEncryptTxt());
			System.out.println( "Signing Txt : " + sendObj.getSigningTxt());
			
			
			// Get <-->
			
			String res;
			user = users.get(1);
			res = app.getMsg(user, sendObj);
			
			users = users.reversed();
			
			System.out.println(green + "\nGet Message --> " + res);
		}
		scanner.close();
	}
}