package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;

import DataManager;
import LoginControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataManager dm = new DataManager();
        LoginControl control = new LoginControl(dm);
        PrintWriter writer = response.getWriter();
       
        String userName;
        String password;
        String[] userNameList = request.getParameterValues("loginid");
        String[] passwordList = request.getParameterValues("password");
        userName = userNameList[0];
        password = passwordList[0];

        AccountObject account = control.processLogin(userName, password);
       
        //Generate response HTML file
        if (account == null) {
                    writer.println("Login Failed <br>");
                    writer.println("<p> If you do not have a club admin account and wish to create one click the link below <br/> <a href=RequestClubAdminAccessForm.html> Request Club Admin Access </a> </p>");
                    writer.println("<p><a href=MainUI.html> Home </a> </p>");
        			writer.println("<p><a href=LoginUI.html> Login </a> </p>");
        }else{
                    writer.println("<p> Login Successful </p>");
                    HttpSession session=request.getSession(); 
                    session.setAttribute("User", account);
                    writer.println("<p><a href=MainUI.html> Home </a> </p>");
        }
	}

}
