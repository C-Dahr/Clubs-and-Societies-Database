/**
 * 
 */


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class EditClubControl {

	private DataManager dataManager;
	private String clubToEdit = null;

	public EditClubControl(DataManager dm) {
		this.dataManager = dm;
	}
	public void processEditClub(String nameIn, String descIn, String locationIn) {
		// begin-user-code
		// TODO Auto-generated method stub
		dataManager.updateClubInfo(clubToEdit, nameIn, descIn, locationIn);
		// end-user-code
	}
	public boolean checkForClub(String clubName) {
		ClubObject club = dataManager.getClubByClubName(clubName);
		if(club == null) {
			return false;
		}
		clubToEdit = club.name;
		return true;
	}
}