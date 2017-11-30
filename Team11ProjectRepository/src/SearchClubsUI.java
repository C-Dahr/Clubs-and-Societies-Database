/**
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class SearchClubsUI {

	private SearchClubsControl searchClubsControl;

	public SearchClubsUI(SearchClubsControl controlIn) {
		this.searchClubsControl = controlIn;
	}
	public void displaySearchForm() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("Enter one or more keywords and end with '0'.");
		// end-user-code
	}

	public void displayRetrievedClubs(ArrayList<ClubObject> clubs) {
		// begin-user-code
		// TODO Auto-generated method stub
		if(clubs.size() == 0)
			displayNoClubsFoundMessage();
		else {
			System.out.println("Club Search Results:");
			for(int i = 0; i < clubs.size(); i++) {
				System.out.println("Club name: " + clubs.get(i).name);
				System.out.println("Description: " + clubs.get(i).description);
				System.out.println("Location: " + clubs.get(i).location);
				System.out.println("Club Leader: " + clubs.get(i).clubAdmin);
			}
		}
		// end-user-code
	}

	public void displayNoClubsFoundMessage() {
		// begin-user-code
		// TODO Auto-generated method stub
		System.out.println("No clubs were found matching your search keywords.");
		// end-user-code
	}

	public void enterFilters() {
		// begin-user-code
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> keywordList = new ArrayList<String>();
		while (true) {
			String keyword = scanner.next();
			if(keyword.equals("0")) break;
			keywordList.add(keyword);
		}
		scanner.close();
		
		ArrayList<ClubObject> club = searchClubsControl.processSearch(keywordList);

		displayRetrievedClubs(club);
		// end-user-code
	}
}