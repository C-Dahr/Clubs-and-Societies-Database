
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
 * Servlet implementation class RequestClubAdminAccessServlet
 */
@WebServlet("/RequestClubAdminAccessServlet")
public class RequestClubAdminAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestClubAdminAccessServlet() {
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
        RequestClubAdminAccessControl control = new RequestClubAdminAccessControl(dm);
        PrintWriter writer = response.getWriter();
       
        String firstName, lastName, userName, password, email;
        String[] firstNameList = request.getParameterValues("firstName");
        String[] lastNameList = request.getParameterValues("lastName");
        String[] userNameList = request.getParameterValues("loginid");
        String[] passwordList = request.getParameterValues("password");
        String[] emailList = request.getParameterValues("email");
        firstName = firstNameList[0];
        lastName = lastNameList[0];
        userName = userNameList[0];
        password = passwordList[0];
        email = emailList[0];
   

        ClubAdminRequestObject request = new ClubAdminRequestObject(firstName,lastName,userName,password,email);
        boolean result = control.processFormSubmission();
       
        //Generate response HTML file
        if (result == false) {
                    writer.println("Club Admin Request Submission Failed <br>");
                    writer.println("<p>Form may not have been filled out properly or user name is already taken</p>");
                    writer.println("<p><a href=RequestClubAdminAccessForm.html> Try Again </a> </p>");
                    writer.println("<p><a href=MainUI.html> Home </a> </p>");
        			
        }else{
        			writer.println("Club Admin Request Submission Succeeded <br>");
                    writer.println("<p> Please wait for an admin to approve your request. An email will be sent when it has either be approved or denied.</p>");
                    writer.println("<p><a href=MainUI.html> Home </a> </p>");
        }
	}

}
