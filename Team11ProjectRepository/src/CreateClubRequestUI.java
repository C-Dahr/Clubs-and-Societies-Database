import java.util.Scanner;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CreateClubRequestUI {

	private CreateClubRequestControl createClubRequestControl;
	
	public CreateClubRequestUI(CreateClubRequestControl control) {
		this.createClubRequestControl = control;
	}

	public void displayCreateClubRequestForm() {
		// begin-user-code
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter suggested club name: ");
		String newClubName = sc.nextLine();
		System.out.println("Enter club description: ");
		String newClubDesc = sc.nextLine();
		System.out.println("Enter club location: ");
		String newLocation = sc.nextLine();
		
		sc.close();
		
		ClubRequestObject formInfo = new ClubRequestObject("id", "name", newClubName, newClubDesc, newLocation);
		
		boolean result = createClubRequestControl.processCreateClubRequest(formInfo);
		if(result) {
			displayConfirmation();
		}
		else {
			displayErrorMessage();
		}
		// end-user-code
	}

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