package baimenak;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import helper.db.MySQLdb;


public class SignupServlet extends HttpServlet{
	
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignupServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignupServlet");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() SignupServlet");
    	
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String izenAbizen = request.getParameter("izenAbizen");
		String abizena1 = request.getParameter("1abizena");
		String abizena2 = request.getParameter("2abizena");
		String NIF = request.getParameter("NIF");
		String helbidea = request.getParameter("Helbidea");
		String telefonoa =request.getParameter("Telefonoa"); 
		System.out.println("     Extracting request parameters: " + email + " " + password + " " +
		izenAbizen + " " + abizena1 + " " + abizena2 + " " + NIF + " " + helbidea
		+ " " + telefonoa);
		boolean error= false;
		request.setAttribute("error", error);
		String emaitza = mySQLdb.setUserInfo(email, password, izenAbizen, abizena1, abizena2, NIF, helbidea, telefonoa);
			if (emaitza == null){
			System.out.println("     Updating users table in the database");
			System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
			}
			else{
			error=true;
			request.setAttribute("error", error);
			System.out.println("     Redirecting the user to signup.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/signup.jsp");
			rd.forward(request, response);
			}
		
        System.out.println("---> Exiting doPost() SignupServlet");
    }
}

