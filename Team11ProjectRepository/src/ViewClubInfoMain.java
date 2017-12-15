
public class ViewClubInfoMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		ViewClubInfoControl control = new ViewClubInfoControl(dm);
		ViewClubInfoUI ui = new ViewClubInfoUI(control);
		
		ui.selectClub();
	}

}
