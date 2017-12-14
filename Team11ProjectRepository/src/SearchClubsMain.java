public class SearchClubsMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		SearchClubsControl control = new SearchClubsControl(dm);
		SearchClubsUI ui = new SearchClubsUI(control);
		
		ui.displaySearchForm();
		ui.enterFilters();
	}

}
