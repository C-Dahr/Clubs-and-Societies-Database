public class ViewClubInfoControl {

	private DataManager dataManager;

	public ViewClubInfoControl(DataManager dm) {
		this.dataManager = dm;
	}

	public ClubObject processViewClubInfo(String clubName) {
		return dataManager.getClubByClubName(clubName);
	}
}