import java.util.Scanner;

public class ViewClubInfoUI {

	private ViewClubInfoControl viewClubInfoControl;

	public ViewClubInfoUI(ViewClubInfoControl control) {
		this.viewClubInfoControl = control;
	}

	public void displayClubInfo(ClubObject club) {
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("Club name: " + club.name);
		System.out.println("Description: " + club.description); 
		System.out.println("Location: " + club.location);
		System.out.println("Club Leader: " + club.clubAdmin);
		System.out.println("----------------------------------------");
	}
	
	public void selectClub() {
		System.out.println("Enter a club name to view: ");
		Scanner sc = new Scanner(System.in);
		String clubName = sc.nextLine();
		sc.close();
		
		ClubObject club = viewClubInfoControl.processViewClubInfo(clubName);
		displayClubInfo(club);
	}
}