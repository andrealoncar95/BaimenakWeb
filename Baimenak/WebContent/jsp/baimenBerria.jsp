<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>NewBaimen</title>
		<link href="/Baimenak/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
	<header>
		<h1>Eraikuntza baimenak eskatzeko tokia</h1>
		<h3>Baimen berri bat eskatu</h3>
	</header>
	<% if (request.getAttribute("txarto") == null){
			request.setAttribute("txarto", false);
		}
		if ((boolean) request.getAttribute("txarto")) { %>
		<section>
			<font color="white"> Ezin izan da baimena ondo sartu</font>
		</section>
		<%} %>
		<section>
			<form method="POST" action="/Baimenak/servlet/NewBaimenServlet">
				<table>
	   				<tr>
	   					<td>Baimenaren izena</td>
	   					<td><input name="izena"/></td>
	   				</tr>
	   				<tr>
	   					<td>Kokalekua</td>
	   					<td><input name="kokalekua"/></td>
	   				</tr>
	   				<tr>
	   					<td>Eraikuntza lanen kostua</td>
	   					<td><input name="kostua"/></td>
	   				</tr>
	 			</table>
				<button>Sortu</button>
			</form>
			<a href="/Baimenak/html/mainForm.html" style="text-decoration: none">
				<button>Menu nagusira bueltatu</button>
			</a>
	</section>
		<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
	</body>
</html>