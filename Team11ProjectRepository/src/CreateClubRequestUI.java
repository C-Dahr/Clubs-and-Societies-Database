import java.util.Scanner;
public class CreateClubRequestUI {

	private CreateClubRequestControl createClubRequestControl;
	
	public CreateClubRequestUI(CreateClubRequestControl control) {
		this.createClubRequestControl = control;
	}

	public void displayCreateClubRequestForm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter suggested club name: ");
		String newClubName = sc.nextLine();
		System.out.println("Enter club description: ");
		String newClubDesc = sc.nextLine();
		System.out.println("Enter club location: ");
		String newLocation = sc.nextLine();
		
		sc.close();
		
		ClubRequestObject formInfo = new ClubRequestObject("id", "name", newClubName, newClubDesc, newLocation);
		
		boolean result = createClubRequestControl.processCreateClubRequest(formInfo);
		if(result) {
			displayConfirmation();
		}
		else {
			displayErrorMessage();
		}
	}

	public void displayConfirmation() {
		System.out.println("Request submitted successfully.");
	}

	public void displayErrorMessage() {
		System.out.println("Error submitting request.");
	}
}