package baimenak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

/**
 * Servlet implementation class BaimenaHautatu
 */
@WebServlet("/BaimenaHautatu")
public class BaimenaHautatu extends HttpServlet {
       
private MySQLdb mySQLdb; 
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() BaimenaHautatu");
		
		mySQLdb = new MySQLdb(); 
		
		System.out.println("---> Exiting init() BaimenaHautatu");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() BaimenaHautatu");
    		
        doPost(request, response);
        	
        System.out.println("---> Exiting doGet() BaimenaHautatu");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() BaimenaHautatu");
    	
    	response.setHeader("Cache-Control", "no-cache");
		
    	if(request.getSession(false) == null) {
    		System.out.println("     User is not logged in");
    		
    		System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
    	} else {
    		System.out.println("     User is logged in");
    		
    		String id = request.getParameter("idbaimenak");
    		request.getSession().setAttribute("idB", id);
    		System.out.println("     Redirecting the user to baimenUpdate.html");
    		RequestDispatcher rd = request.getRequestDispatcher("/html/baimenUpdate.html");
    		rd.forward(request, response);
    		
    	}
    	
        System.out.println("---> Exiting doPost() BaimenaHautatu");
    }
}