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
	<%  if (request.getAttribute("ondoN") == null){
			request.setAttribute("ondoN", false);
		}
		if (request.getAttribute("ondoE") == null){
			request.setAttribute("ondoE", false);
		}
		if (request.getAttribute("ondoU") == null){
			request.setAttribute("ondoU", false);
		}
		if ((boolean) request.getAttribute("ondoN")) { %>
		<section>
			<font color="white"> Baimen berria ondo gehitu da</font>
		</section>
		<%} 
		else if ((boolean) request.getAttribute("ondoE")) { %>
		<section>
			<font color="white"> Baimena ondo eguneratu da</font>
		</section>
		<%} 
		else if ((boolean) request.getAttribute("ondoU")) { %>
		<section>
			<font color="white"> Erabiltzailearen datuak ondo eguneratu dira</font>
		</section>
		<%} %>
	<section>
			<a href="/Baimenak/html/mainForm.html" style="text-decoration: none">
				<button>Menu nagusira bueltatu</button>
			</a>
	</section>
	
	<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
</body>
</html>