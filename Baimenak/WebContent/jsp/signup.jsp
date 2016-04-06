<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>SignupForm</title>
		<link href="/Baimenak/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Eraikuntza baimenak eskatzeko tokia</h1>
			<h3>Erregistratu</h3>
		</header>
		<% if (request.getAttribute("error") == null){
			request.setAttribute("error", false);
		}
		if ((boolean) request.getAttribute("error")) { %>
		<section>
			<font color="white"> Beharrezko kanpoak bete behar dira</font>
		</section>
		<%} %>
		<section>
			<form method="POST" action="/Baimenak/servlet/SignupServlet">
				<table>
	   				<tr>
	   					<td>Email</td>
	   					<td><input name="email"/></td>
	   				</tr>				
	   				<tr>
	   					<td>Password</td>
	   					<td><input type="password" name="password"/></td>
	   				</tr>
	   				<tr>
	   					<td>Izena</td>
	   					<td><input name="izenAbizen"></td>
	   				</tr>
	   				<tr>
	   					<td>Lehengo Abizena</td>
	   					<td><input name="1abizena"/></td>
	   				</tr>
	   				<tr>
	   					<td>Bigarren Abizena</td>
	   					<td><input name="2abizena"/></td>
	   				</tr>
	   				<tr>
	   					<td>NIF</td>
	   					<td><input name="NIF"/></td>
	   				</tr>
	   				<tr>
	   					<td>Helbidea</td>
	   					<td><input name="Helbidea"/></td>
	   				</tr>
	   				<tr>
	   					<td><font2>*</font2> Telefonoa</td>
	   					<td><input name="Telefonoa"/></td>
	   				</tr>
	 			</table>
	 			<section><font1>* Ez dira beharrezkoak</font1></section>
				<button>Bidali</button>
			</form>
			<a href="/Baimenak/jsp/loginForm.jsp" style="text-decoration: none">
				<button>Atzera</button>
			</a>
		</section>
		<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
	</body>
</html>