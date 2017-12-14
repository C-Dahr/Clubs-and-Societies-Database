import java.util.ArrayList;

public class BrowseClubsUI {

	private BrowseClubsControl browseClubsControl;

	public BrowseClubsUI(BrowseClubsControl controlIn) {
		this.browseClubsControl = controlIn;
	}

	public void displayRetrievedClubs(ArrayList<ClubObject> clubsIn) {
		if (clubsIn.size() == 0) 
			System.out.println("No clubs found.");
		else {
			System.out.println("Club Results: ");
			for(int i = 0; i < clubsIn.size(); i++) {
				System.out.println("Club name: " + clubsIn.get(i).name);
				System.out.println();
			}
		}
	}
	
	public void showClubs() {
		ArrayList<ClubObject> clubs = browseClubsControl.processBrowseClubs();
		
		this.displayRetrievedClubs(clubs);
	}
}