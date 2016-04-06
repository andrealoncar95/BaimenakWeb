<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*, helper.info.*" %>
<% ArrayList<BaimenakInfo> baimenakList = (ArrayList) request.getAttribute("baimenakList");
  %>
<html>
	<head>
		<title>Baimenak ikusi</title>
		<link href="/Baimenak/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Eraikuntza baimenak eskatzeko tokia</h1>
			<h3>Baimen guztien infomazioa</h3>
		</header>
		<section>
		<%if (baimenakList.size()==0){
			%>
			<font>Ez daukazu eraikuntza baimenik, </font><a href="/Baimenak/jsp/baimenBerria.jsp" style="text-decoration: none">
				<font1>baimen berri bat sortu</font1>
			</a>
			<br>
		<% } else{%>
			<table>
				<tr>
					   				<th>Kodea</th>
									<th>Izena</th>
									<th>Kokalekua</th>
									<th>Eraikuntzaren kostua</th>
									<th>Baimenaren kostua</th>
	   			</tr>
			<% for(int i = 0; i < baimenakList.size(); i++) {
				BaimenakInfo baimenakInfo = baimenakList.get(i);
				int id = baimenakInfo.getId();%>
	   			<tr>
	   				<td><%= id %> </td>
	   				<td><%= baimenakInfo.getIzena() %></td>
	   				<td><%= baimenakInfo.getKokalekua() %></td>
	   				<td><%= baimenakInfo.getKostuaE() %> euro</td>
	   				<td><%= baimenakInfo.getKostuaB() %> euro</td>
	   			</tr>
	   				<% } %>
	 			</table>
	 		<%} %>
	 			<br>
			<a href="/Baimenak/html/mainForm.html" style="text-decoration: none">
				<button>Menu nagusira bueltatu</button>
			</a>
	</section>
		<footer><img alt="mungiako udala" src="/Baimenak/img/m.jpg" width="90" height="80" align="left">
	HIRIGINTZA ATALA</footer>
	</body>
</html>