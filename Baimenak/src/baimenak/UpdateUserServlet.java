package baimenak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.db.MySQLdb;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
private MySQLdb mySQLdb; 
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() UpdateUserServlet");
		
		mySQLdb = new MySQLdb(); 
		
		System.out.println("---> Exiting init() UpdateUserServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() UpdateUserServlet");
    		
        doPost(request, response);
        	
        System.out.println("---> Exiting doGet() UpdateUserServlet");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() UpdateUserServlet");
    	
    	response.setHeader("Cache-Control", "no-cache");
		
    	if(request.getSession(false) == null) {
    		System.out.println("     User is not logged in");
    		
    		System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
    	} else {
    		System.out.println("     User is logged in");
    		
    		int id= (int)request.getSession().getAttribute("id");
			String izena = request.getParameter("izena");
			String abizen1= request.getParameter("abizen1");
			String abizen2 = request.getParameter("abizen2");
			String NIF = request.getParameter("NIF");
			String helbide = request.getParameter("helbide");
			String telefono =request.getParameter("tele");

			mySQLdb.UserEguneratu(izena,abizen1,abizen2,NIF,helbide,telefono,id);
			request.setAttribute("ondoU", true);
			System.out.println("     Redirecting the user to ondo.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ondo.jsp");
			rd.forward(request, response);

    	}
    	
        System.out.println("---> Exiting doPost() UpdateUserServlet");
    }
}
