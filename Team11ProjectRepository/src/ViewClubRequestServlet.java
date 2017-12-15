
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
 * Servlet implementation class ViewClubRequestServlet
 */
@WebServlet("/ViewClubRequestServlet")
public class ViewClubRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClubRequestServlet() {
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
		CreateClubControl control = new CreateClubControl(dm);
        PrintWriter writer = response.getWriter();
        
        String requestID;
        String[] requestList = request.getParameterValues("request");
        requestID = requestList[0];
        ClubRequestObject request = dm.getClubRequestByID(requestID);
        writer.println("<h1> " + request.clubName + "'s Request Page</h1>");
		writer.println("<p>Club Name: " + request.clubName  + " </p>");
		writer.println("<p>Description: " + request.description + " </p>");
		writer.println("<p>Location: " + request.location + "</p>");
		writer.println("<form action=ProcessClubRequestServlet method=post>");
		HttpSession session = request.getSession();
		session.setAttribute("ClubRequest",request);
		writer.println("<button name='status' type='submit' value='" + true +"'>Approve</button><br>");
		writer.println("<button name='status' type='submit' value='" + false +"'>Delete</button><br>");
		writer.println("</form>");
		writer.println("<p><a href=CreateClubServlet.java> Manage Club Requests </a> </p>");
		writer.println("<p><a href=MainUI.html> Home </a> </p>");
	}

}
