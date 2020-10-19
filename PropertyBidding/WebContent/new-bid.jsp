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
	<form action = "insertBidServlet" method = "post" >
		Select a Bidder:  <br/>
		<table>
			<c:forEach items="${requestScope.allBidders}" var="currentbidder">
				<tr>
					<td><input type = "radio" name = "bidderId" value = "${currentbidder.id}"></td>
					<td>${currentbidder.getName()}</td>
			</c:forEach>
		</table>
		<br/>Select a Property:  <br/>
		<table>
			<c:forEach items="${requestScope.allProperties}" var="currentProperty">
				<tr>
					<td><input type = "radio" name = "propertyId" value="${currentProperty.id}"></td>
					<td>Address: ${currentProperty.getAddress()},</td>
					<td>${currentProperty.getCity()},</td>
					<td>${currentProperty.getState()},</td>
					<td>${currentProperty.getZip()},</td>
					<td>${currentProperty.showDateSold()}</td>
				</tr>
			</c:forEach>
		</table>
		<br/>Enter Bid Amount: <input type = "text" name = "bidAmount">
		<input type = "submit" value = "add" name="doThisToBid">	
	</form>
</body>
</html>