import java.util.ArrayList;

public class BrowseClubsControl {

	private DataManager dataManager;

	public BrowseClubsControl(DataManager dmIn) {
		this.dataManager = dmIn;
	}
	public ArrayList<ClubObject> processBrowseClubs() {
		return dataManager.getAllClubs();
	}
}