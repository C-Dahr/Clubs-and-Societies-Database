
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
 * Servlet implementation class ChangedClubServlet
 */
@WebServlet("/ChangedClubServlet")
public class ChangedClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangedClubServlet() {
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
		EditClubControl control = new EditClubControl(dm);
        PrintWriter writer = response.getWriter();
        
        String description, location;
        String[] descriptionList = request.getParameterValues("description");
        String[] locationList = request.getParameterValues("location");
        description = descriptionList[0];
        location = locationList[0];
        
        ClubAdminAccountObject clubAdmin;
        
        try {
        	HttpSession session=request.getSession(false); 
        	clubAdmin = (ClubAdminAccountObject) session.getAttribute("User");
        }catch(Exception e){
        	clubAdmin = null;
        } 
        writer.println("<!DOCTYPE html><html><body>");
        if (clubAdmin == null) {
			 writer.println("You are not logged into a club admin account.<br>");
			 writer.println("<p><a href=index.html> Home </a> </p>");
 			 writer.println("<p><a href=LoginUI.html> Login </a> </p>");
		}else {
			 control.processEditClub(clubAdmin.clubName, description, location);
			 writer.println("Edit Club Succesful <br>");
             writer.println("<p><a href=index.html> Home </a> </p>");
		}
        writer.println("</body></html>");
	}

}
