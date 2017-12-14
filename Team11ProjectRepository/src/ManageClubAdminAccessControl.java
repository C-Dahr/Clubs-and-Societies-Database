import java.util.ArrayList;

public class ManageClubAdminAccessControl {

	private DataManager dataManager;
	
	public ManageClubAdminAccessControl(DataManager dm) {
		dataManager = dm;
	}
	public ArrayList<ClubAdminRequestObject> processGetAdminRequests() {
		return dataManager.getAllAdminRequests();
	}

	public boolean processNewAdmin(String requestId) {

		ClubAdminRequestObject request = dataManager.getClubAdminRequestByID(requestId);
		
		ClubAdminAccountObject newClubAdmin = new ClubAdminAccountObject(request.username, request.password, request.firstName, request.lastName, request.email);
		
		boolean result = dataManager.setNewClubAdmin(newClubAdmin);
		dataManager.removeAdminRequest(requestId);
		
		return result;
	}

	public boolean processDenyAdmin(String requestId) {
		return dataManager.removeAdminRequest(requestId);
	}
}