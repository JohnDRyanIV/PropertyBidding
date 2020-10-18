<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new bidder</title>
</head>
<body>
	<form action = "addBidderServlet" method="post">
		Name: <input type ="text" name="name" value="${bidderToAdd.name}">
		<input type = "submit" value = "Add Bidder">
	</form>
	<a href = "index.html">Return to homepage</a>

</body>
</html>