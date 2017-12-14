public class ClubAdminRequestObject extends RequestObject {

	public String username;

	public String password;

	public String firstName;

	public String lastName;

	public String email;

	public String clubName;

	public ClubAdminRequestObject(String requestId, String senderName, String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String emailIn, String clubNameIn) {
		super(requestId, senderName);
		this.username = usernameIn;
		this.password = passwordIn;
		this.firstName = firstNameIn;
		this.lastName = lastNameIn;
		this.email = emailIn;
		this.clubName = clubNameIn;
	}
}