
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
 * Servlet implementation class ViewClubInfoServlet
 */
@WebServlet("/ViewClubInfoServlet")
public class ViewClubInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClubInfoServlet() {
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
		ViewClubInfoControl control = new ViewClubInfoControl(dm);
        PrintWriter writer = response.getWriter();
        
        String clubName;
        String[] clubList = request.getParameterValues("club");
        clubName = clubList[0];
        ClubObject club = control.processViewClubInfo();
        writer.println("<h1> " + club.name + "'s Info Page</h1>");
		writer.println("<p>Club Name: " + club.name  + " </p>");
		writer.println("<p>Description: " + club.description + " </p>");
		writer.println("<p>Location: " + club.location + "</p>");
		writer.println("<p><a href=index.html> Home </a> </p>");
	}

}
