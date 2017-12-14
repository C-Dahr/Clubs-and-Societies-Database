public class ClubAdminAccountObject extends AccountObject{

	public String clubName;

	public ClubAdminAccountObject (String idIn, String passwordIn, String firstNameIn, String lastNameIn, String emailIn) {
		super(idIn, passwordIn, firstNameIn, lastNameIn, emailIn);
		clubName = null;
	}
}