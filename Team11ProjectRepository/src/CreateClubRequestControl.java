/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CreateClubRequestControl {

	private DataManager dataManager;

	public CreateClubRequestControl(DataManager dm) {
		this.dataManager = dm;
	}
	
	public boolean processCreateClubRequest(ClubRequestObject formInfo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return dataManager.setNewCreateClubRequest(formInfo);
		// end-user-code
	}
}