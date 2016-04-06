<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>LoginForm</title>
<link href="/Baimenak/css/styleSheet.css" rel="stylesheet" />

	</head>
	<body>
		<header>
			<h1>Eraikuntza baimenak eskatzeko tokia</h1>
			
		</header>
		<%  if (request.getAttribute("o") == null){
			request.setAttribute("o", false);
		}
		if ((boolean) request.getAttribute("o")) { %>
		<section>
			<font color="white"> Pasahitza okerra da</font>
		</section>
		<%} %>
	<section>
	<form method="POST" action="/Baimenak/servlet/SegurServlet">
			<table>
				<tr><th>Segurtasunagatik pasahitza berriz sartu</th></tr>
				<tr>
					<td align="center"><input type= password name="pass" /></td>
				</tr>
			</table>
	</section>
	<section>
				<button>Bidali</button>
	</form>
			<a href="/Baimenak/html/mainForm.html" style="text-decoration: none">
				<button>Menu nagusira bueltatu</button>
			</a>
	</section>
	<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer> 
</body>
</html>