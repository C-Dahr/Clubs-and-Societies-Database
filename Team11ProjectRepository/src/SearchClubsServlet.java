
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
 * Servlet implementation class SearchClubsServlet
 */
@WebServlet("/SearchClubsServlet")
public class SearchClubsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClubsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 DataManager dm = new DataManager();
         SearchClubsControl control = new SearchClubsControl(dm);
         PrintWriter writer = response.getWriter();
        
         ArrayList<String> keywords = new ArrayList<String>();
       //Retrieve submitted user input data with name “keywords”
         String[] keywordString = request.getParameterValues("keywords");
         StringTokenizer tokenizer = new StringTokenizer(keywordString[0]);
         while (tokenizer.hasMoreTokens()) {
                     keywords.add(tokenizer.nextToken());
         }

         ArrayList<ClubObject > clubs = control.processSearch(keywords);
        
         //Generate response HTML file
         writer.println("<!DOCTYPE html><html><body>");
         if (clubs.size() == 0)
                     writer.println("No clubs were found. <br>");
         else {
        	 		 writer.println("<form action=ViewClubInfoServlet method=post>");
                     writer.println("<p> Club Search Results: </p>");
        	 		 writer.println("<p>");
                     for(int i = 0; i < clubs.size(); i++) {
                                 writer.println(clubs.get(i).name + "<button name='club' type='submit' value='" + clubs.get(i).name +"'>View Info</button><br>");
                     }
                     writer.println("</p>");
                     writer.println("</form>");
                     writer.println("<p><a href=index.html> Home </a> </p>");
         }
         writer.println("</body></html>");
	}

}
