<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Property Bid</title>
</head>
<body>
	<form action = "addBidServlet" method = "post" >
		Select a Bidder:  <br/>
		<select name = "selectedBidder" multiple size = "6">
			<c:forEach items="${requestScope.allBidders}" var="currentbidder">
				<option value="${currentbidder.id}">${currentbidder.getName()}</option>
			</c:forEach>
		</select>
		<br/>Select a Property:  <br/>
		<select name = "selectedProperty" multiple size = "6">
			<c:forEach items="${requestScope.allProperties}" var = "currentProperty">
				<option value="${currentProperty.id}">${currentProperty.toString()}</option>
			</c:forEach>
		</select>
		<br/>Enter Bid Amount: <input type = "text" name = "bidAmount">
		<input type = "submit" value = "add" name="doThisToBid">	
	</form>
</body>
</html>