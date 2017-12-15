
public class EditClubMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		EditClubControl control = new EditClubControl(dm);
		EditClubUI ui = new EditClubUI(control);
		
		boolean clubExists = ui.enterInfo();
		if(clubExists) {
			ui.displayEditClubForm();
		}
		else {
			System.out.println("Error: club not found.");
		}
	}

}
