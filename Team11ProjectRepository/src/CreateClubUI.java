/**
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CreateClubUI {

	private CreateClubControl createClubControl;

	private LoginUI loginUI;
	
	public CreateClubUI(CreateClubControl control) {
		this.createClubControl = control;
	}
	
	public void chooseOptions() {
		ArrayList<ClubRequestObject> requests = createClubControl.processDisplayClubRequests();
		displayClubRequests(requests);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Which request would you like to view? (enter request ID):");
		String requestIDtoView = sc.nextLine();
		
		displayClubRequestInfo(requestIDtoView, requests);
		
		System.out.println("Would you like to Approve (1) or Remove (2) the club request?:");
		String decision = sc.nextLine();
		
		switch (decision) {
			case "1":
				createClubControl.processApproval(requestIDtoView);
				break;
			case "2":
				createClubControl.processRemoval(requestIDtoView);
				break;
			default:
				System.out.println("Incorrect input.");
		}
	}

	private void displayClubRequests(ArrayList<ClubRequestObject> clubRequestsIn) {
		// begin-user-code
		// TODO Auto-generated method stub
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
		// end-user-code
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

	public void displayConfirmation(boolean result) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}