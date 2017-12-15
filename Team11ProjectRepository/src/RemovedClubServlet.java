
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
 * Servlet implementation class RemovedClubServlet
 */
@WebServlet("/RemovedClubServlet")
public class RemovedClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovedClubServlet() {
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
		RemoveClubControl control = new RemoveClubControl(dm);
        PrintWriter writer = response.getWriter();
        
        String clubName;
        String[] clubList = request.getParameterValues("club");
        clubName = clubList[0];
        Boolean result = control.processRemoveClubs(clubName);
        if(result = true){
        	writer.println(clubName + "Deleted Succesfully<br>");
        	writer.println("<p><a href=MainUI.html> Home </a> </p>");
        }else{
        	writer.println("<p><a href=RemoveClubServlet.java> Try Again </a> </p>");
        	writer.println("<p><a href=MainUI.html> Home </a> </p>");
        }
	}

}
