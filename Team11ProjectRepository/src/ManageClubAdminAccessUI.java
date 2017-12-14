import java.util.ArrayList;
import java.util.*;

public class ManageClubAdminAccessUI {

	private ManageClubAdminAccessControl manageClubAdminAccessControl;

	public ManageClubAdminAccessUI (ManageClubAdminAccessControl control) {
		manageClubAdminAccessControl = control;
	}
	
	public void displayAdminRequests() {
		ArrayList<ClubAdminRequestObject> requests = manageClubAdminAccessControl.processGetAdminRequests();
		
		if(requests.size() == 0)
			System.out.println("No requests found.");
		else {
			System.out.println("Club Administrator Requests:");
			for(int i = 0; i < requests.size(); i++) {
				System.out.println("Request ID: " + requests.get(i).username);
				System.out.println("Name of Sender: " + requests.get(i).firstName + " " + requests.get(i).lastName);
				System.out.println("Name of Club: " + requests.get(i).clubName);
			}
		}
	}
	
	public void chooseOptions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which request would you like to view? (enter request ID):");
		String requestName = sc.next();
		System.out.println("Would you like to Approve (1) or Remove (2) the aministrator request?:");
		int option = sc.nextInt();
		sc.close();
		
		boolean success = false;
		if(option == 1)
			success = manageClubAdminAccessControl.processNewAdmin(requestName);
		else if(option == 2)
			success = manageClubAdminAccessControl.processDenyAdmin(requestName);
		
		displayConfirmation(success);
	}

	public void displayConfirmation(boolean result) {
		if(result)
			System.out.println("Request completed successfully!");
		else
			System.out.println("Incorrect input.");
	}
}