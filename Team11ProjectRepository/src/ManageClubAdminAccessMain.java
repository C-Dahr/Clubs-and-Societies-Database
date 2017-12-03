
public class ManageClubAdminAccessMain {
	public static void main(String[] args) {
		DataManager dm = new DataManager();
		ManageClubAdminAccessControl control = new ManageClubAdminAccessControl(dm);
		ManageClubAdminAccessUI ui = new ManageClubAdminAccessUI(control);
		
		ui.displayAdminRequests();
	}
}
