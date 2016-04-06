package baimenak;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.MySQLdb;


public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() LoginServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() LoginServlet");
	}
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doGet() LoginServlet");
    	
    	response.setHeader("Cache-Control", "no-cache");
    	
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("     Extracting request parameters: " + email + " " + password);

		String username = mySQLdb.getUsername(email, password);
		if(username == null) {
			request.setAttribute("b", true);
			System.out.println("     Login error: redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
		} else {
			int id = mySQLdb.getId(email, password);
			HttpSession session = request.getSession(true);
			session.setAttribute("username",  username);
			session.setAttribute("id", id);
			String sessionID = session.getId();
			System.out.println("     User session for " + username + ": " + sessionID);
			System.out.print("     Getting loggedin userlist from servlet context: ");
			ServletContext context = request.getServletContext();
			
			System.out.println("     Redirecting the user to mainForm.html");
			RequestDispatcher rd = context.getRequestDispatcher("/html/mainForm.html");
			rd.forward(request, response);
		}
		
		System.out.println("---> Exiting doGet() LoginServlet");
    }
}


