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
		<%  if (request.getAttribute("b") == null){
			request.setAttribute("b", false);
		}
		if ((boolean) request.getAttribute("b")) { %>
		<section>
			<font color="white"> Email edo pasahitz okerra</font>
		</section>
		<%} %>
		<section>
			<form method="POST" action="/Baimenak/servlet/LoginServlet">
				<table>
	   				<tr>
	   					<td ><input name="email" placeholder="EMAIL"/></td>
	   				</tr>
	   				<tr>
	   					<td><input type="password" name="password" placeholder="PASAHITZA"/></td>
	   				</tr>
	 			</table>
	 			<button>Sartu</button>
			</form>
		</section>
		<section>
			<a href="/Baimenak/jsp/signup.jsp" style="text-decoration: none">
				<font color="white">Sign Up</font>
			</a>
		</section>
		<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
	</body>
</html>