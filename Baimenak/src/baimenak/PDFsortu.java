package baimenak;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import helper.db.MySQLdb;

/**
 * Servlet implementation class BaimenaHautatu2
 */
@WebServlet("/PDFsortu")
public class PDFsortu extends HttpServlet {

	private MySQLdb mySQLdb; 

	public void init(ServletConfig config) {
		System.out.println("---> Entering init() PDFsortu");

		mySQLdb = new MySQLdb(); 

		System.out.println("---> Exiting init() PDFsortu");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---> Entering doGet() PDFsortu");

		doPost(request, response);

		System.out.println("---> Exiting doGet() PDFsortu");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---> Entering doPost() PDFsortu");

		response.setHeader("Cache-Control", "no-cache");

		if(request.getSession(false) == null) {
			System.out.println("     User is not logged in");

			System.out.println("     Redirecting the user to loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("     User is logged in");

			String id = request.getParameter("kodea");
			System.out.println(id);
			int i= (int)request.getSession().getAttribute("id");
			ArrayList<Object> baimenInfo=mySQLdb.getBaimenarenPDF(id,i);
			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			try {
				Document document = new Document();
				PdfWriter.getInstance(document, out);
				document.open();
				document.add(new Paragraph("ERAIKUNTZA BAIMENA"));
				document.add(new Paragraph("Kodea: " + baimenInfo.get(0)));
				document.add(new Paragraph("Izena: " + baimenInfo.get(1)));
				document.add(new Paragraph("Kokalekua: " + baimenInfo.get(2)));
				document.add(new Paragraph("Eraikuntzaren kostua: " + baimenInfo.get(3)));
				document.add(new Paragraph("Baimenaren kostua: " + baimenInfo.get(4)));
				document.add(new Paragraph("Eskatzailearen izena: " + baimenInfo.get(6)));
				document.add(new Paragraph("Eskatzailearen abizena: " + baimenInfo.get(7)));
				document.add(new Paragraph("Eskatzailearen NIF: " + baimenInfo.get(8)));
				document.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			out.flush();
			out.close();
		}


		System.out.println("---> Exiting doPost() PDFsortu");
	}
}