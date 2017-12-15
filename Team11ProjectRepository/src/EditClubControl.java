public class EditClubControl {

	private DataManager dataManager;
	private String clubToEdit = null;

	public EditClubControl(DataManager dm) {
		this.dataManager = dm;
	}
	
	public void processEditClub(String nameIn, String descIn, String locationIn) {
		dataManager.updateClubInfo(clubToEdit, nameIn, descIn, locationIn);
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