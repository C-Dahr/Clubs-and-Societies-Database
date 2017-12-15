import java.util.ArrayList;

public class CreateClubControl {

	private DataManager dataManager;
	
	public CreateClubControl(DataManager dm) {
		this.dataManager = dm;
	}

	public void processApproval(String requestID) throws NullPointerException {
		ClubRequestObject request = dataManager.getClubRequestByID(requestID);
		
		ClubObject newClub = new ClubObject();
		newClub.name = request.clubName;
		newClub.description = request.description;
		newClub.location = request.location;
		newClub.clubAdmin = request.nameOfRequestSender;
		
		dataManager.setNewClub(newClub);
		dataManager.removeClubRequest(requestID);
	}

	public void processRemoval(String requestID) throws NullPointerException {
		dataManager.removeClubRequest(requestID);
	}

	public ArrayList<ClubRequestObject> processDisplayClubRequests() {
		return dataManager.getAllClubRequests();
	}
}