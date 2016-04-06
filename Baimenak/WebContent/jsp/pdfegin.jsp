<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="helper.db.MySQLdb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>LoginForm</title>
<link href="/Baimenak/css/styleSheet.css" rel="stylesheet" />

	</head>
	<body>
		<header>
			<h1>Eraikuntza baimenak eskatzeko tokia</h1>
			<h3>Baimena PDFra inprimatu</h3>
		</header>
	<section>
	<form method="POST" action="/Baimenak/servlet/PDFsortu">
			<table>
				<tr>
					<td>Baimenaren kodea-a:</td>
					<td><select name="kodea">
					<% 
					String id= request.getSession().getAttribute("id").toString();
					int k=0;
					MySQLdb mySQLdb= new MySQLdb();
					ArrayList<Object> b= new ArrayList<Object>();
					b= mySQLdb.getBaimenarenId(id);
					while (k<b.size()) {
					%><option value="<%= b.get(k) %>"> <%= b.get(k) %> </option>
					<% k++; 
					}%>
					</select></td>
				</tr>
			</table>
				<button>Bidali</button>
	</form>
	</section>
	<section>
			<a href="/Baimenak/html/mainForm.html" style="text-decoration: none">
				<button>Menu nagusira bueltatu</button>
			</a>
	</section>
	<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
</body>
</html>