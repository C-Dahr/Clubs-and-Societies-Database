/**
 * 
 */

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class BrowseClubsUI {

	private BrowseClubsControl browseClubsControl;

	public BrowseClubsUI(BrowseClubsControl controlIn) {
		this.browseClubsControl = controlIn;
	}

	public void displayRetrievedClubs(ArrayList<ClubObject> clubsIn) {
		// begin-user-code
		// TODO Auto-generated method stub
		if (clubsIn.size() == 0) 
			System.out.println("No clubs found.");
		else {
			System.out.println("Club Results: ");
			for(int i = 0; i < clubsIn.size(); i++) {
				System.out.println("Club name: " + clubsIn.get(i).name);
				System.out.println();
			}
		}
		// end-user-code
	}
	
	public void showClubs() {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<ClubObject> clubs = browseClubsControl.processBrowseClubs();
		
		this.displayRetrievedClubs(clubs);
		// end-user-code
	}
}