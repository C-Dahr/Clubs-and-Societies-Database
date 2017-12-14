
public class RequestClubAdminAccessMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager(); 
		RequestClubAdminAccessControl control = new RequestClubAdminAccessControl(dm);
		RequestClubAdminAccessUI ui = new RequestClubAdminAccessUI(control);

		ui.displayClubAdminForm();
	}

}
