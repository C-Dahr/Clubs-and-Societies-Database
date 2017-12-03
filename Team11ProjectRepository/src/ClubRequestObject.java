/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
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