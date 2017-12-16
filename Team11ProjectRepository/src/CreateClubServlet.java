
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
 * Servlet implementation class CreateClubServlet
 */
@WebServlet("/CreateClubServlet")
public class CreateClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClubServlet() {
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
         CreateClubControl control = new CreateClubControl(dm);
         PrintWriter writer = response.getWriter();
        
       

         ArrayList<ClubRequestObject> requests = control.processDisplayClubRequests();
        
         //Generate response HTML file
         if (requests.size() == 0)
                     writer.println("No club requests were found. <br>");
         else {
        	 		 writer.println("<form action=ViewClubRequestServlet method=post>");
                     writer.println("<p> Club Requests: </p>");
        	 		 writer.println("<p>");
                     for(int i = 0; i < requests.size(); i++) {
                                 writer.println(requests[i].clubName + "<button name='request' type='submit' value='" + requests[i].requestID +"'>View Info</button><br>");
                     }
                     writer.println("</p>");
                     writer.println("</form>");
                     writer.println("<p><a href=index.html> Home </a> </p>");
         }
	}

}
