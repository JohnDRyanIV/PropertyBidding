<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit a bidder</title>
</head>

<body>
	<form action = "editBidderServlet" method = post>
		Name: <input type = "text" name = "name" value = "${bidderToEdit.name}"><p></p>
		<input type = "hidden" name = "id" value = "${bidderToEdit.id}">
		<input type = "submit" value = "Save edited bidder">
	</form>
	<a href = "index.jsp"><button>Return to homepage</button></a>
</body>
</html>