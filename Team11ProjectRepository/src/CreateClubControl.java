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
public class CreateClubControl {

	private DataManager dataManager;
	
	public CreateClubControl(DataManager dm) {
		this.dataManager = dm;
	}

	public boolean processApproval(String requestID) {
		// begin-user-code
		// TODO Auto-generated method stub
		ClubRequestObject request = dataManager.getClubRequestByID(requestID);
		
		ClubObject newClub = new ClubObject();
		newClub.name = request.clubName;
		newClub.description = request.description;
		newClub.location = request.location;
		newClub.clubAdmin = request.nameOfRequestSender;
		
		boolean result = dataManager.setNewClub(newClub);
		
		return result;
		
		// end-user-code
	}

	public boolean processRemoval(String requestID) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}

	public ArrayList<ClubRequestObject> processDisplayClubRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
		return dataManager.getAllClubRequests();
		// end-user-code
	}
}