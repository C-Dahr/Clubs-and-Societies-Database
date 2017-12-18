public class EditClubControl {

	private DataManager dataManager;

	public EditClubControl(DataManager dm) {
		this.dataManager = dm;
	}
	
	public void processEditClub(String nameIn, String descIn, String locationIn) {
		dataManager.updateClubInfo(nameIn, descIn, locationIn);
	}
	
	public boolean checkForClub(String clubName) {
		ClubObject club = dataManager.getClubByClubName(clubName);
		if(club == null) {
			return false;
		}
		clubToEdit = club.name;
		return true;
	}
}