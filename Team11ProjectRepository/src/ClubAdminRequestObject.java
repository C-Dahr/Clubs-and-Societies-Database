/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class ClubAdminRequestObject extends RequestObject {

	public String id;

	public String password;

	public String firstName;

	public String lastName;

	public String email;

	public Object clubName;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ClubAdminRequestObject(String requestId, String senderName, String idIn, String passwordIn, String firstNameIn, String lastNameIn, String emailIn, String clubNameIn) {
		super(requestId, senderName);
		this.id = idIn;
		this.password = passwordIn;
		this.firstName = firstNameIn;
		this.lastName = lastNameIn;
		this.email = emailIn;
		this.clubName = clubNameIn;
	}
}