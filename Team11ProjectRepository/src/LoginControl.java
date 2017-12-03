/**
 * 
 */


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author dmccardl
 */
public class LoginControl {

	private DataManager dataManager;
	
	public LoginControl(DataManager dm) {
		this.dataManager = dm;
	}

	public AccountObject processLogin(String id, String pass) {
		// begin-user-code
		// TODO Auto-generated method stub
		AccountObject account;
		account = dataManager.getClubAdminAccount(id, pass);
		if(account == null);
			account = dataManager.getMainAdminAccount(id, pass);
		return account;
		// end-user-code
	}
}