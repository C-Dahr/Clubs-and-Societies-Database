public class ClubRequestObject extends RequestObject{

	public String clubName;

	public String description;

	public String location;

	public ClubRequestObject(String id, String senderName, String nameIn, String descIn, String locationIn) {
		super(id, senderName);
		this.clubName = nameIn;
		this.description = descIn;
		this.location = locationIn;
	}
}