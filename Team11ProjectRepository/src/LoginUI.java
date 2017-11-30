import java.util.Scanner;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class LoginUI {
	
	private LoginControl loginControl;
	
	public LoginUI (LoginControl controlIn) {
		loginControl = controlIn;
	}

	public void displayLoginForm() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Enter username and password separated by space: ");
		// end-user-code
	}

	public void displayConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Login confirmed.");
		// end-user-code
	}

	public void displayLoginFailedMessage() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Login failed. Account not found.");
		// end-user-code
	}

	public void enterLoginInfo() {
		// begin-user-code
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String password = sc.next();
		AccountObject account = loginControl.processLogin(id,password);
		
		if(account.id == null)
			displayLoginFailedMessage();
		else
			displayConfirmation();
		// end-user-code
	}
}