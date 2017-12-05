/**
 * 
 */

import java.util.ArrayList;
import java.util.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class ManageClubAdminAccessUI {

	private ManageClubAdminAccessControl manageClubAdminAccessControl;
	private LoginUI loginUI;

	public ManageClubAdminAccessUI (ManageClubAdminAccessControl control) {
		manageClubAdminAccessControl = control;
	}
	
	public void displayAdminRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<ClubAdminRequestObject> requests = manageClubAdminAccessControl.processGetAdminRequests();
		
		if(requests.size() == 0)
			System.out.println("No requests found.");
		else {
			System.out.println("Club Administrator Requests:");
			for(int i = 0; i < requests.size(); i++) {
				System.out.println("User ID: " + requests.get(i).id);
				System.out.println("Requestor Name: " + requests.get(i).firstName + " " + requests.get(i).lastName);
				System.out.println("Club Name: " + requests.get(i).clubName);
			}
		}
		// end-user-code
	}
	
	public void chooseOptions() {
		Scanner sc = new Scanner(System.in);
		//Should match format of create club (temporary)
		System.out.println("Choose a request by entering the requestor name as listed above:");
		String requestName = sc.next();
		System.out.println("To approve the request enter 1, to deny the request enter 2:");
		int option = sc.nextInt();
		
		boolean success = false;
		if(option == 1)
			success = manageClubAdminAccessControl.processNewAdmin(requestName);
		else if(option == 2) {
			success = manageClubAdminAccessControl.processDenyAdmin(requestName);
		}
		
		displayConfirmation(success);
	}

	public void displayConfirmation(boolean result) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(result)
			System.out.println("Action successful.");
		else
			System.out.println("Action unsuccessful.");
		// end-user-code
	}
}