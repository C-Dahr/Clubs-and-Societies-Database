import java.util.ArrayList;

public class SearchClubsControl {

	private DataManager dataManager;
	
	public SearchClubsControl(DataManager dmIn) {
		this.dataManager = dmIn;
	}

	public ArrayList<ClubObject> processSearch(ArrayList<String> parameters) {
		return dataManager.getClubsFromFilterSearch(parameters);
	}
}