import java.util.Scanner;

public class RequestClubAdminAccessUI {

	private RequestClubAdminAccessControl requestClubAdminAccessControl;

	public RequestClubAdminAccessUI(RequestClubAdminAccessControl control) {
		 this.requestClubAdminAccessControl = control;
	}
	
	public void displayClubAdminForm() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter first name: ");
		 String firstName = sc.nextLine();
		 System.out.println("Enter last name: ");
		 String lastName = sc.nextLine();
		 System.out.println("Enter a username: ");
		 String id = sc.nextLine();
		 System.out.println("Enter an account password: ");
		 String password = sc.nextLine();
		 System.out.println("Enter an email: ");
		 String email = sc.nextLine();
		 System.out.println("Enter suggested club name: ");
		 String clubName = sc.nextLine();
		 String senderName = firstName + " " + lastName;

		 sc.close();
		 
		 ClubAdminRequestObject formInfo = new ClubAdminRequestObject("id", senderName, id, password, firstName, lastName, email, clubName);
		 
		 boolean result = requestClubAdminAccessControl.processFormSubmission(formInfo);
		 if(result) {
			 displayConfirmation();
		 }
		 else {
			 displayErrorMessage();
		 }
	}
	
	public void displayConfirmation() {
		System.out.println("Request submitted successfully.");
	}

	public void displayErrorMessage() {
		System.out.println("Error submitting request.");
	}
}