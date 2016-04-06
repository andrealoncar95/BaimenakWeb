<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>UpdateUser</title>
		<link href="/Baimenak/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
	<header>
		<h1>Eraikuntza baimenak eskatzeko tokia</h1>
		<h3>Email edo pasahitza eguneratu</h3>
	</header>
	<%  if (request.getAttribute("ondoU") == null){
			request.setAttribute("ondoU", false);
		}
		if ((boolean) request.getAttribute("ondoU")) { %>
		<section>
			<font color="white"> Email-a erabilita dago</font>
		</section>
		<%} %>
		<section>
			<form method="POST" action="/Baimenak/servlet/UpdatePassServlet">
				<table>
	   				<tr>
	   					<td>Email berria</td>
	   					<td><input name="email"/></td>
	   				</tr>
	   				<tr>
	   					<td>Pasahitz berria</td>
	   					<td><input name="pass"/></td>
	   				</tr>
	 			</table>
				<button>Eguneratu</button>
			</form>
			<a href="/Baimenak/html/user.html" style="text-decoration: none">
				<button>Atzera</button>
			</a>
	</section>
		<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
	</body>
</html>

