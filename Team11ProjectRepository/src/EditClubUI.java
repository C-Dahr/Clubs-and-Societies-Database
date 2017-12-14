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
public class EditClubUI {

	private EditClubControl editClubControl;
	
	public EditClubUI(EditClubControl control) {
		this.editClubControl = control;
	}

	public void displayEditClubForm() {
		// begin-user-code
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new club name: ");
		String newClubName = sc.nextLine();
		System.out.println("Enter new club description: ");
		String newClubDesc = sc.nextLine();
		System.out.println("Enter new club location: ");
		String newLocation = sc.nextLine();
		
		sc.close();
		
		editClubControl.processEditClub(newClubName, newClubDesc, newLocation);
		displayConfirmation();
		// end-user-code
	}

	public void displayConfirmation() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Request successfully completed.");
		// end-user-code
	}

	public boolean enterInfo() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("What is your club name?:");
		Scanner sc = new Scanner(System.in);
		String clubName = sc.nextLine();
		sc.close();
		return editClubControl.checkForClub(clubName);
		// end-user-code
	}
}