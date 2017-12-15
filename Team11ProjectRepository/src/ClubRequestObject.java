public class ClubRequestObject extends RequestObject{

	public String clubName;

	public String description;

	public String location;

	public ClubRequestObject(String id, String senderName, String descIn, String locationIn, String nameIn) {
		super(id, senderName);
		this.clubName = nameIn;
		this.description = descIn;
		this.location = locationIn;
	}
}