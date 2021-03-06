
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
 * Servlet implementation class EditClubServlet
 */
@WebServlet("/EditClubServlet")
public class EditClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClubServlet() {
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
        ClubAdminAccountObject clubAdmin;
        try {
        	HttpSession session=request.getSession(false); 
        	clubAdmin =(ClubAdminAccountObject) session.getAttribute("User");
        }catch(Exception e){
        	clubAdmin = null;
        }
        writer.println("<!DOCTYPE html><html><body>");
        if (clubAdmin == null) {
			 writer.println("You are not logged into a club admin account.<br>");
 			 writer.println("<p><a href=LoginUI.html> Login </a> </p>");
 			 writer.println("<p><a href=index.html> Home </a> </p>");
		}else {
			writer.println("<h1> UNB CSDB Create Club Request Form </h1>");
			writer.println("<form action=ChangedClubServlet method=Post>");
			writer.println("<p>Club Name: " + clubAdmin.clubName + " </p>");
			writer.println("<p>Description:  <input type=text name=description value=" + one + " size=40></p>");
			writer.println("<p>Location:  <input type=text name=location value=" + two + " size=40></p>");
			writer.println("<p><input type=submit value=Submit></p>");
			writer.println("</form>");
			writer.println("<p><a href=index.html> Home </a> </p>");
		}
        writer.println("</body></html>");
	}

}
