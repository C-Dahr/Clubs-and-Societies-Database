package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;

import DataManager;
import ManageClubAdminAccessControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewClubAdminRequestServlet
 */
@WebServlet("/ViewClubAdminRequestServlet")
public class ViewClubRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClubAdminRequestServlet() {
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
		ManageClubAdminAccessControl control = new ManageClubAdminAccessControl(dm);
        PrintWriter writer = response.getWriter();
        
        String requestID;
        String[] requestList = request.getParameterValues("request");
        requestID = requestList[0];
        ClubAdminRequestObject request = dm.getClubAdminRequestByID(requestID);
        writer.println("<h1> " + request.firstName + "'s Request Page</h1>");
        writer.println("<p>Club Name: " + request.firstName  + " </p>");
        writer.println("<p>Club Name: " + request.lastName  + " </p>");
        writer.println("<p>Club Name: " + request.email  + " </p>");
		writer.println("<p>Club Name: " + request.username  + " </p>");
		writer.println("<p>Description: " + request.clubName + " </p>");
		writer.println("<form action=ProcessClubAdminRequestServlet method=post>");
		HttpSession session = request.getSession();
		session.setAttribute("ClubAdminRequest",request);
		writer.println("<button name='status' type='submit' value='" + true +"'>Approve</button><br>");
		writer.println("<button name='status' type='submit' value='" + false +"'>Delete</button><br>");
		writer.println("</form>");
		writer.println("<p><a href=ManageClubAdminAccessServlet.java> Manage Club Admin Requests </a> </p>");
		writer.println("<p><a href=MainUI.html> Home </a> </p>");
	}

}
