import java.util.Scanner;
import java.util.ArrayList;

public class CreateClubUI {

	private CreateClubControl createClubControl;
	
	public CreateClubUI(CreateClubControl control) {
		this.createClubControl = control;
	}
	
	public void chooseOptions() {
		try {
			ArrayList<ClubRequestObject> requests = createClubControl.processDisplayClubRequests();
			displayClubRequests(requests);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Which request would you like to view? (enter request ID):");
			String requestIDtoView = sc.nextLine();
			
			displayClubRequestInfo(requestIDtoView, requests);
			
			System.out.println("Would you like to Approve (1) or Remove (2) the club request?:");
			String decision = sc.nextLine();
			
			sc.close();
			
			switch (decision) {
				case "1":
					createClubControl.processApproval(requestIDtoView);
					displayConfirmation();
					break;
				case "2":
					createClubControl.processRemoval(requestIDtoView);
					displayConfirmation();
					break;
				default:
					System.out.println("Incorrect input.");
			}
		}
		catch(NullPointerException e) {
			System.out.println("Error resolving request ID.");
		}
		
	}

	private void displayClubRequests(ArrayList<ClubRequestObject> clubRequestsIn) {
		if (clubRequestsIn.size() == 0) 
			System.out.println("No requests found.");
		else {
			System.out.println("Club Request Results: ");
			for(int i = 0; i < clubRequestsIn.size(); i++) {
				System.out.println("Request ID: " + clubRequestsIn.get(i).requestID);
				System.out.println("Name of Club: " + clubRequestsIn.get(i).clubName);
				System.out.println("Name of Sender: " + clubRequestsIn.get(i).nameOfRequestSender);
				System.out.println();
			}
		}
	}
	
	private void displayClubRequestInfo(String idToView, ArrayList<ClubRequestObject> requestIn) {
		if (requestIn.size() == 0) 
			System.out.println("No request found.");
		else {
			for(int i = 0; i < requestIn.size(); i++) {
				if(requestIn.get(i).requestID.equals(idToView)) {
					System.out.println("Request ID: " + requestIn.get(i).requestID);
					System.out.println("Name of Club: " + requestIn.get(i).clubName);
					System.out.println("Name of Sender: " + requestIn.get(i).nameOfRequestSender);
					System.out.println("Description: " + requestIn.get(i).description);
					System.out.println("Location: " + requestIn.get(i).location);
					System.out.println();
				}
			}
		}
	}

	public void displayConfirmation() {
		System.out.println("Request completed successfully!");
	}
}