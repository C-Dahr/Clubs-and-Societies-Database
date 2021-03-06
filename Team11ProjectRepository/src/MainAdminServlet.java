
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class MainAdminServlet
 */
@WebServlet("/MainAdminServlet")
public class MainAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataManager dm = new DataManager();
        PrintWriter writer = response.getWriter();
        MainAdminAccountObject mainAdmin;
        try {
        	HttpSession session=request.getSession(false); 
        	mainAdmin =(MainAdminAccountObject) session.getAttribute("User");
        }catch(Exception e){
        	mainAdmin = null;
        }
        writer.println("<!DOCTYPE html><html><body>");
		if (mainAdmin == null) {
			writer.println("You are not logged into a main admin account.<br>");
			writer.println("<p><a href=index.html> Home </a> </p>");
 			writer.println("<p><a href=LoginUI.html> Login </a> </p>");
		}else {
			writer.println("<p><a href=CreateClubServlet> Manage Club Requests <a/> </p>");
			writer.println("<p><a href=ManageClubAdminAccessServlet> Manage Club Admin Requests <a/> </p>");
			writer.println("<p><a href=index.html> Home </a> </p>");
		}
		writer.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}