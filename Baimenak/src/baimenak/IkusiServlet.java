package baimenak;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;
import helper.info.BaimenakInfo;

/**
 * Servlet implementation class IkusiServlet
 */
@WebServlet("/IkusiServlet")
public class IkusiServlet extends HttpServlet {
private MySQLdb mySQLdb;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() IkusiServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() IkusiServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() IkusiServlet");
    		
        doPost(request, response);
        	
        System.out.println("---> Exiting doGet() IkusiServlet");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() IkusiServlet");
    	
    	response.setHeader("Cache-Control", "no-cache");
		
    	if(request.getSession(false) == null) {
    		System.out.println("     User is not logged in");
    		
    		System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
    	} else {
    		System.out.println("     User is logged in");

    		ArrayList<BaimenakInfo> baimenakList = mySQLdb.getAllBaimenak((int)request.getSession().getAttribute("id"));
    		request.setAttribute("baimenakList", baimenakList);
    		System.out.println("     Redirecting the user to baimenakIkusi.jsp");
    		RequestDispatcher rd = request.getRequestDispatcher("/jsp/baimenakIkusi.jsp");
    		rd.forward(request, response);

    	}
    	
        System.out.println("---> Exiting doPost() IkusiServlet");
    }
    
}