/**
 * 
 */
import java.util.Scanner;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RequestClubAdminAccessUI {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private RequestClubAdminAccessControl requestClubAdminAccessControl;

	public RequestClubAdminAccessUI(RequestClubAdminAccessControl control) {
		 this.requestClubAdminAccessControl = control;
	}
	
	
	public void displayClubAdminForm() {
		// begin-user-code
		// TODO Auto-generated method stub

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
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param result
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void displayConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Request submitted successfully.");
		// end-user-code
	}

	public void displayErrorMessage() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Error submitting request.");
		// end-user-code
	}
}