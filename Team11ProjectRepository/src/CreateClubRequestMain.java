
public class CreateClubRequestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataManager dm = new DataManager();
		CreateClubRequestControl control = new CreateClubRequestControl(dm);
		CreateClubRequestUI ui = new CreateClubRequestUI(control);
		
		ui.displayCreateClubRequestForm();
	}

}
