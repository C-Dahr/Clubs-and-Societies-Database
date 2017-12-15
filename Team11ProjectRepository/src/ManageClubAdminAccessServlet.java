
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
 * Servlet implementation class ManageClubAdminAccessServlet
 */
@WebServlet("/ManageClubAdminAccessServlet")
public class ManageClubAdminAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageClubAdminAccessServlet() {
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
		 ManageClubAdminAccessControl control = new ManageClubAdminAccessControl(dm);
         PrintWriter writer = response.getWriter();
        
       

         ArrayList<ClubAdminRequestObject> requests = control.processGetAdminRequests();
        
         //Generate response HTML file
         if (requests.size() == 0)
                     writer.println("No club admin requests were found. <br>");
         else {
        	 		 writer.println("<form action=ViewClubAdminRequestServlet method=post>");
                     writer.println("<p> Club Admin Requests: </p>");
        	 		 writer.println("<p>");
                     for(int i = 0; i < requests.size(); i++) {
                                 writer.println(requests[i].username + "<button name='request' type='submit' value='" + requests[i].requestID +"'>View Info</button><br>");
                     }
                     writer.println("</p>");
                     writer.println("</form>");
                     writer.println("<p><a href=MainUI.html> Home </a> </p>");
         }
	}

}
