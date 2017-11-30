
import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class SearchClubsControl {

	private DataManager dataManager;
	
	public SearchClubsControl(DataManager dmIn) {
		this.dataManager = dmIn;
	}

	public ArrayList<ClubObject> processSearch(ArrayList<String> parameters) {
		// begin-user-code
		// TODO Auto-generated method stub
		return dataManager.getClubsFromFilterSearch(parameters);
		// end-user-code
	}
}