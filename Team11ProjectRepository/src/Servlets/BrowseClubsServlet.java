package Servlets;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataManager;
import BrowseClubsControl;

/**
 * Servlet implementation class BrowseClubsServlet
 */
@WebServlet("/BrowseClubsServlet")
public class BrowseClubsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseClubsServlet() {
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
         BrowseClubsControl control = new BrowseClubsControl(dm);
         PrintWriter writer = response.getWriter();
        
       

         ArrayList<ClubInfoObject > clubs = control.getAllClubs();
        
         //Generate response HTML file
         if (clubs.size() == 0)
                     writer.println("No clubs were found. <br>");
         else {
        	 		 writer.println("<form action=ViewClubInfoServlet method=post>")
                     writer.println("<p> Browse Clubs: </p>");
        	 		 writer.println("<p>");
                     for(int i = 0; i < clubs.size(); i++) {
                                 writer.println(clubs(i).name + "<button name='club' type='submit' value='" + clubs(i).name +"'>View Info</button><br>");
                     }
                     writer.println("</p>");
                     writer.println("</form>");
                     writer.println("<p><a href=MainUI.html> Home </a> </p>");
         }
	}

}
