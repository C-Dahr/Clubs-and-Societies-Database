
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateClubRequestServlet
 */
@WebServlet("/CreateClubRequestServlet")
public class CreateClubRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClubRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataManager dm = new DataManager();
        CreateClubRequestControl control = new CreateClubRequestControl(dm);
        PrintWriter writer = response.getWriter();
       
        String clubName, description, location;
        String[] clubNameList = request.getParameterValues("clubName");
        String[] descriptionList = request.getParameterValues("description");
        String[] locationList = request.getParameterValues("location");
        clubName = clubNameList[0];
        description = descriptionList[0];
        location = locationList[0];

        ClubRequestObject request = new ClubRequestObject(clubName,description,location);
        boolean result = control.processCreateClubRequest();
       
        //Generate response HTML file
        if (result == false) {
                    writer.println("Club Request Submission Failed <br>");
                    writer.println("<p>Form may not have been filled out properly or name is already taken</p>");
                    writer.println("<p><a href=CreateClubRequestForm.html> Try Again </a> </p>");
                    writer.println("<p><a href=index.html> Home </a> </p>");
        			
        }else{
        			writer.println("Club Request Submission Succeeded <br>");
                    writer.println("<p> Please wait for an admin to approve your request. An email will be sent when it has either be approved or denied.</p>");
                    writer.println("<p><a href=index.html> Home </a> </p>");
        }
	}

}
