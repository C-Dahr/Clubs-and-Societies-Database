
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RemoveClubServlet
 */
@WebServlet("/RemoveClubServlet")
public class RemoveClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveClubServlet() {
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
		// TODO Auto-generated method stub
		 DataManager dm = new DataManager();
		 RemoveClubControl control = new RemoveClubControl(dm);
         PrintWriter writer = response.getWriter();
         MainAdminAccountObject admin;
         ArrayList<ClubInfoObject > clubs = control.getAllClubs();
        
         //Generate response HTML file
         try {
     		HttpSession session=request.getSession(false); 
            admin =(MainAdminAccountObject) session.getAttribute("User");
         }catch(Exception e){
            admin = null;
         }
         if (admin == null) {
     			 writer.println("You are not logged into a main admin account.<br>");
     			 writer.println("<p><a href=MainUI.html> Home </a> </p>");
      			 writer.println("<p><a href=LoginUI.html> Login </a> </p>");
     	}else {
         if (clubs.size() == 0)
                     writer.println("No clubs were found. <br>");
         else {
        	 		 writer.println("<form action=RemovedClubServlet.java method=post>");
                     writer.println("<p> Choose a Club to Remove: </p>");
        	 		 writer.println("<p>");
                     for(int i = 0; i < clubs.size(); i++) {
                                 writer.println(clubs(i).name + "<button name='club' type='submit' value='" + clubs(i).name +"'>Remove Club</button><br>");
                     }
                     writer.println("</p>");
                     writer.println("</form>");
                     writer.println("<p><a href=MainUI.html> Home </a> </p>");
         }
	}

}
