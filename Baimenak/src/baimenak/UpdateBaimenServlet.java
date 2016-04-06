package baimenak;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

public class UpdateBaimenServlet extends HttpServlet {
private MySQLdb mySQLdb; 
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() UpdateBaimenaServlet");
		
		mySQLdb = new MySQLdb(); 
		
		System.out.println("---> Exiting init() UpdateBaimenaServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() UpdateBaimenaServlet");
    		
        doPost(request, response);
        	
        System.out.println("---> Exiting doGet() UpdateBaimenaServlet");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() UpdateBaimenaServlet");
    	
    	response.setHeader("Cache-Control", "no-cache");
		
    	if(request.getSession(false) == null) {
    		System.out.println("     User is not logged in");
    		
    		System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
    	} else {
    		System.out.println("     User is logged in");
    		
    		String idB = request.getSession().getAttribute("idB").toString();
    		String id=  request.getSession().getAttribute("id").toString();
			String izena = request.getParameter("izena");
			String kokalekua= request.getParameter("kokalekua");
			String kostuaE = request.getParameter("kostua");
			double kst = 0.0;
			if (kostuaE != ""){
				kst = Double.valueOf(kostuaE);
			}
			double kostuaB= 0;
			if (kst>=100){
				kostuaB= kst*0.1;
			}
			else if (kst<100){
				kostuaB= kst*0.05;
			}

			mySQLdb.baimenaEguneratu(izena, kokalekua, kostuaE, kostuaB, idB, id);
			request.setAttribute("ondoE", true);
			System.out.println("     Redirecting the user to ondo.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ondo.jsp");
			rd.forward(request, response);

    	}
    	
        System.out.println("---> Exiting doPost() UpdateBaimenaServlet");
    }
}
