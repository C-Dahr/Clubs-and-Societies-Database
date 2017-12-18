
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
 * Servlet implementation class ProcessClubAdminRequestServlet
 */
@WebServlet("/ProcessClubAdminRequestServlet")
public class ProcessClubAdminRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessClubAdminRequestServlet() {
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
        
        String status;
        String[] statusList = request.getParameterValues("status");
        status = statusList[0];
        
		HttpSession session=request.getSession(false); 
        String adminRequest = (String) session.getAttribute("ClubAdminRequestID");
        
        writer.println("<!DOCTYPE html><html><body>");
        if (status.equals("true")){
        	control.processNewAdmin(adminRequest);
			 writer.println("Club Admin successfully created<br>");
			 writer.println("<p><a href=ManageClubAdminAccessServlet> Manage Club Admin Requests </a> </p>");
			 writer.println("<p><a href=index.html> Home </a> </p>");
		}else {
			control.processDenyAdmin(adminRequest);
			writer.println("Club Admin Request deleted <br>");
			writer.println("<p><a href=ManageClubAdminAccessServlet> Manage Club Admin Requests </a> </p>");
            writer.println("<p><a href=index.html> Home </a> </p>");
		}
        writer.println("</body></html>");
	}
}