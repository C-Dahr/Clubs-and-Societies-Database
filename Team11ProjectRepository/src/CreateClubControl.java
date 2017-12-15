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
		
		String[] strings = request.nameOfRequestSender.split("\\s+");
		
		dataManager.setNewClub(newClub, strings[0]);
		dataManager.removeClubRequest(requestID);
	}

	public void processRemoval(String requestID) throws NullPointerException {
		dataManager.removeClubRequest(requestID);
	}

	public ArrayList<ClubRequestObject> processDisplayClubRequests() {
		return dataManager.getAllClubRequests();
	}
}