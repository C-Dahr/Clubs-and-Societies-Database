import java.util.Scanner;

public class EditClubUI {

	private EditClubControl editClubControl;
	
	public EditClubUI(EditClubControl control) {
		this.editClubControl = control;
	}

	public void displayEditClubForm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new club name: ");
		String newClubName = sc.nextLine();
		System.out.println("Enter new club description: ");
		String newClubDesc = sc.nextLine();
		System.out.println("Enter new club location: ");
		String newLocation = sc.nextLine();
		
		sc.close();
		
		editClubControl.processEditClub(newClubName, newClubDesc, newLocation);
		displayConfirmation();
	}

	public void displayConfirmation() {
		System.out.println("Request successfully completed.");
	}

	public boolean enterInfo() {
		System.out.println("What is your club name?:");
		Scanner sc = new Scanner(System.in);
		String clubName = sc.nextLine();
		sc.close();
		return editClubControl.checkForClub(clubName);
	}
}