package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;

import DataManager;
import ChangedClubControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangedClubServlet
 */
@WebServlet("/ProcessClubRequestServlet")
public class ProcessClubRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessClubRequestServlet() {
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
        
        String status;
        String[] statusList = request.getParameterValues("status");
        status = statusList[0];
        
		HttpSession session=request.getSession(false); 
        ClubRequestObject request =(ClubRequestObject) session.getAttribute("ClubRequest");
      
        if (status.equals("true")){
        	control.processApproval(request.requestID);
			 writer.println("Club successfully created<br>");
			 writer.println("<p><a href=CreateClubServlet.java> Manage Club Requests </a> </p>");
			 writer.println("<p><a href=MainUI.html> Home </a> </p>");
		}else {
			control.processRemoval(request.requestID);
			writer.println("Club Request Deleted <br>");
			writer.println("<p><a href=CreateClubServlet.java> Manage Club Requests </a> </p>");
            writer.println("<p><a href=MainUI.html> Home </a> </p>");
		}
	}
}