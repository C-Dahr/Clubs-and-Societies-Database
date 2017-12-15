
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataManager;
/**
 * Servlet implementation class ViewOrderStatusServlet
 */
@WebServlet("/ViewOrderStatusServlet")
public class ViewOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataManager dm = new DataManager();
        ViewOrderStatusControl control = new ViewOrderStatusControl(dm);
        PrintWriter writer = response.getWriter();
        MainAdminAccountObject mainAdmin;
        try {
		HttpSession session=request.getSession(false); 
        mainAdmin =(MainAdminAccountObject) session.getAttribute("User");
        }catch(Exception e){
        	mainAdmin = null;
        }
		if (mainAdmin == null) {
			 writer.println("You are not logged into a main admin account.<br>");
			 writer.println("<p><a href=MainUI.html> Home </a> </p>");
 			writer.println("<p><a href=LoginUI.html> Login </a> </p>");
		}else {
			writer.println("<p><a href=CreateClubServlet.java> Manage Club Requests <a/> </p>");
			writer.println("<p><a href=RemoveClubServlet.java> Remove a Club <a/> </p>");
			writer.println("<p><a href=ManageClubAdminRequestServlet.java> Manage Club Admin Requests <a/> </p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}