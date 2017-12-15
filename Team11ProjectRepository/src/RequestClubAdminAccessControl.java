public class RequestClubAdminAccessControl {

	private DataManager dataManager;

	public RequestClubAdminAccessControl(DataManager dm) {
		this.dataManager = dm;
	}
	public boolean processFormSubmission(ClubAdminRequestObject formInfo) {
		return dataManager.setNewAdminRequest(formInfo);
	}
}