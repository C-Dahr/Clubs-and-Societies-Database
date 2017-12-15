public class CreateClubRequestControl {

	private DataManager dataManager;

	public CreateClubRequestControl(DataManager dm) {
		this.dataManager = dm;
	}
	
	public boolean processCreateClubRequest(ClubRequestObject formInfo) {
		return dataManager.setNewCreateClubRequest(formInfo);
	}
}