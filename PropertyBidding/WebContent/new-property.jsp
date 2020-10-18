<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new property</title>
</head>
<body>
	<form action = "addPropertyServlet" method = "post">
		Address: <input type = "text" name = "address" value = "${propertyToAdd.address}"><p></p>
		City: <input type = "text" name = "city" value = "${propertyToAdd.city}"><p></p>
		State: <input type = "text" name = "state" value = "${propertyToAdd.state}"><p></p>
		Zipcode: <input type = "text" name = "zip" value = "${propertyToAdd.zip}"><p></p>
		<input type = "submit" value = "Add Property">
	</form>
	<a href = "index.html">Return to homepage</a> 

</body>
</html>