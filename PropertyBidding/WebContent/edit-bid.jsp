<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Bid Amount</title>
</head>
<body>
	<form action = "editBidServlet" method = "post">
		Bidder: ${bidToEdit.getBidder().getName()}  <br/>
		Address: "${bidToEdit.getProperty().getAddress()}"><p></p>
		City: "${bidToEdit.getProperty().getCity()}"><p></p>
		State: "${bidToEdit.getProperty().getState}"><p></p>
		Zipcode: "${bidToEdit.getProperty().getZip()}"><p></p> <br/>
		Bid Amount: <input type = "text" name = "editAmount" value = "${bidToEdit.getAmount()}"> <br/>
		<input type = "hidden" name = "editBidId" value = "${bidToEdit.id}">
		<input type = "submit" value = "Save edited bid">
	</form>
	<a href = "index.html">Return to homepage</a> 
</body>
</html>