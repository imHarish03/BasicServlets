<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
	<%@ page errorPage="error.jsp"%>
	<%
		String message = null;
		String sessionID = null;
		String userName = request.getParameter("userName");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("message"))
					message = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
	%>


	<h3>
		Welcome
		<%=userName%>>
	</h3>
	<h4><%=message%></h4>
	<h4>
		Session ID =
		<%=sessionID%></h4>
	<br>
	<br>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>