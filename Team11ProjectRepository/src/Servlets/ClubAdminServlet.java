package Servlets;
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
        ClubAdminAccountObject clubAdmin;
        try {
		HttpSession session=request.getSession(false); 
        clubAdmin =(ClubAdminAccountObject) session.getAttribute("User");
        }catch(Exception e){
        	clubAdmin = null;
        }
		if (clubAdmin == null) {
			 writer.println("You are not logged into a club admin account.<br>");
			 writer.println("<p><a href=MainUI.html> Home </a> </p>");
 			writer.println("<p><a href=LoginUI.html> Login </a> </p>");
		}else {
			if (clubAdmin.club == null){
				writer.println("<p><a href=CreateClubRequestForm.html> Create a Club Request <a/> </p>");
			}else{
				writer.println("<p><a href=EditClubServlet.java> Edit your Club <a/> </p>");
			}
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