<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new bidder</title>
</head>
<body>
	<form action = "addBidderServlet" method="post">
		Name: <input type ="text" name="name">
		<input type = "submit" value = "Add Bidder">
	</form>
	<a href = "index">Return to homepage</a>

</body>
</html>