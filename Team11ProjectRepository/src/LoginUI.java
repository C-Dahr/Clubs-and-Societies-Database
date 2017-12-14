import java.util.Scanner;

public class LoginUI {
	
	private LoginControl loginControl;
	
	public LoginUI (LoginControl controlIn) {
		loginControl = controlIn;
	}

	public void displayLoginForm() {
		System.out.println("Enter username and password separated by space: ");
	}

	public void displayConfirmation() {
		System.out.println("Login confirmed.");
	}

	public void displayLoginFailedMessage() {
		System.out.println("Login failed. Account not found.");
	}

	public void enterLoginInfo() {
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String password = sc.next();
		AccountObject account = loginControl.processLogin(id,password);
		
		if(account.id == null)
			displayLoginFailedMessage();
		else
			displayConfirmation();
		
		sc.close();
	}
}