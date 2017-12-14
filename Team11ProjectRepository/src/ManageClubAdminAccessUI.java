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
				System.out.println("Request ID: " + requests.get(i).id);
				System.out.println("Name of Sender: " + requests.get(i).firstName + " " + requests.get(i).lastName);
				System.out.println("Name of Club: " + requests.get(i).clubName);
			}
		}
		// end-user-code
	}
	
	public void chooseOptions() {
		Scanner sc = new Scanner(System.in);
		//Should match format of create club (temporary)
		System.out.println("Which request would you like to view? (enter request ID):");
		String requestName = sc.next();
		System.out.println("Would you like to Approve (1) or Remove (2) the aministrator request?:");
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
			System.out.println("Request completed successfully!");
		else
			System.out.println("Incorrect input.");
		// end-user-code
	}
}