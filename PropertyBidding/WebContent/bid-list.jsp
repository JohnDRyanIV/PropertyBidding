<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Bids</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allBids}" var="currentbid">
		<tr> 
			<td><input type="radio" name="id" value="${currentbid.id}"></td>
			<td>${currentbid.property.getAddress()},</td>
			<td>${currentbid.property.getCity()},</td>
			<td>${currentbid.property.getState()},</td>
			<td>${currentbid.property.getZip()},</td>
			<td>Bidder: ${currentbid.bidder.getName()},</td>
			<td>Bid Amount: ${currentbid.formattedBidAmt()},</td>
			<td>${currentbid.property.showDateSold()}</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToBid">
	<input type = "submit" value = "add" name="doThisToBid">
	</form>
</body>
</html>