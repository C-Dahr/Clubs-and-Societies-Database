
public class RequestClubAdminAccessMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataManager dm = new DataManager(); 
		RequestClubAdminAccessControl control = new RequestClubAdminAccessControl(dm);
		RequestClubAdminAccessUI ui = new RequestClubAdminAccessUI(control);

		ui.displayClubAdminForm();
	}

}
