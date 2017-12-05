/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ViewClubInfoControl {

	private DataManager dataManager;

	public ViewClubInfoControl(DataManager dm) {
		this.dataManager = dm;
	}

	public ClubObject processViewClubInfo(String clubName) {
		// begin-user-code
		// TODO Auto-generated method stub
		return dataManager.getClubByClubName(clubName);
		// end-user-code
	}
}