
public class BrowseClubsMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		BrowseClubsControl control = new BrowseClubsControl(dm);
		BrowseClubsUI ui = new BrowseClubsUI(control);
		
		ui.showClubs();
	}

}
