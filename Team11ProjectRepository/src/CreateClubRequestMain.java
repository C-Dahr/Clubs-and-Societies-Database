
public class CreateClubRequestMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		CreateClubRequestControl control = new CreateClubRequestControl(dm);
		CreateClubRequestUI ui = new CreateClubRequestUI(control);
		
		ui.displayCreateClubRequestForm();
	}

}
