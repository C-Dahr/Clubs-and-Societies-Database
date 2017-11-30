
public class BrowseClubsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataManager dm = new DataManager();
		BrowseClubsControl control = new BrowseClubsControl(dm);
		BrowseClubsUI ui = new BrowseClubsUI(control);
		
		ui.showClubs();
	}

}
