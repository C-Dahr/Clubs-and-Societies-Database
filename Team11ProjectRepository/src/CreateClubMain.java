
public class CreateClubMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		CreateClubControl control = new CreateClubControl(dm);
		CreateClubUI ui = new CreateClubUI(control);
		
		ui.chooseOptions();
	}

}
