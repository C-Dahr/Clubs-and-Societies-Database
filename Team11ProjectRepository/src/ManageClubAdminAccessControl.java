/**
 * 
 */

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class ManageClubAdminAccessControl {

	private DataManager dataManager;
	
	public ManageClubAdminAccessControl(DataManager dm) {
		dataManager = dm;
	}
	public ArrayList<ClubAdminRequestObject> processGetAdminRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
		return dataManager.getAllAdminRequests();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param adminName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean processNewAdmin(Object adminName) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param adminName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean processDenyAdmin(String adminName) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}
}