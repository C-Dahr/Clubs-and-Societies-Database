/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RequestClubAdminAccessControl {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private DataManager dataManager;

	public RequestClubAdminAccessControl(DataManager dm) {
		this.dataManager = dm;
	}
	public boolean processFormSubmission(ClubAdminRequestObject formInfo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return dataManager.setNewAdminRequest(formInfo);
		// end-user-code
	}
}