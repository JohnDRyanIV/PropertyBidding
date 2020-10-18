<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Property</title>
</head>
<body>
	<form action = "editPropertyServlet" method = "post">
		Address: <input type = "text" name = "address" value = "${propertyToEdit.address}"><p></p>
		City: <input type = "text" name = "city" value = "${propertyToEdit.city}"><p></p>
		State: <input type = "text" name = "state" value = "${propertyToEdit.state}"><p></p>
		Zipcode: <input type = "text" name = "zip" value = "${propertyToEdit.zip}"><p></p>
		<input type = "hidden" name = "id" value = "${propertyToEdit.id}">
		<input type = "submit" value = "Save edited property">
	</form>
	<a href = "index.html">Return to homepage</a> 

</body>
</html>