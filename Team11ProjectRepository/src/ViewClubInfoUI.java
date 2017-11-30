/**
 * 
 */
import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ViewClubInfoUI {

	private ViewClubInfoControl viewClubInfoControl;

	public ViewClubInfoUI(ViewClubInfoControl control) {
		this.viewClubInfoControl = control;
	}

	public void displayClubInfo(ClubObject club) {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Club name: " + club.name);
		System.out.println("Description: " + club.description); 
		System.out.println("Location: " + club.location);
		System.out.println("Club Leader: " + club.clubAdmin);
		System.out.println("----------------------------------------");
		// end-user-code
	}
	
	public void selectClub() {
		System.out.println("Enter a club name to view: ");
		Scanner sc = new Scanner(System.in);
		String clubName = sc.nextLine();
		sc.close();
		
		ClubObject club = viewClubInfoControl.processViewClubInfo(clubName);
		displayClubInfo(club);
	}
}