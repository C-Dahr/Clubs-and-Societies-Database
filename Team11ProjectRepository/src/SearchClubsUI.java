import java.util.ArrayList;
import java.util.Scanner;

public class SearchClubsUI {

	private SearchClubsControl searchClubsControl;

	public SearchClubsUI(SearchClubsControl controlIn) {
		this.searchClubsControl = controlIn;
	}
	public void displaySearchForm() {
		System.out.println("Enter one or more keywords and end with '0'.");
	}

	public void displayRetrievedClubs(ArrayList<ClubObject> clubs) {
		if(clubs.size() == 0)
			displayNoClubsFoundMessage();
		else {
			System.out.println("Club Search Results:");
			for(int i = 0; i < clubs.size(); i++) {
				System.out.println("Club name: " + clubs.get(i).name);
			}
		}
	}

	public void displayNoClubsFoundMessage() {
		System.out.println("No clubs were found matching your search keywords.");
	}

	public void enterFilters() {
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
	}
}