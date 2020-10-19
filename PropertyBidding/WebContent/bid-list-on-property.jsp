<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Properties by Bid</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
		Address: <input type = "text" name = "address" value = "${propertyForBids.address}"><p></p>
		City: <input type = "text" name = "city" value = "${propertyForBids.city}"><p></p>
		State: <input type = "text" name = "state" value = "${propertyForBids.state}"><p></p>
		Zipcode: <input type = "text" name = "zip" value = "${propertyForBids.zip}"><p></p>
	<table>
	<c:forEach items="${requestScope.allBidsOnProperty}" var="currentbid">
		<tr> 
			<td><input type="radio" name="id" value="${currentbid.id}"></td>
			<td>${currentbid.property.getAddress()}</td>
			<td>${currentbid.property.getCity() }</td>
			<td>${currentbid.property.getState() }</td>
			<td>${currentbid.property.getZip() }</td>
			<td>Bidder: ${currentbid.bidder.getName()}</td>
			<td>Bid Amount: ${currentbid.formattedBidAmt()}</td>
			<td>${currentbid.property.showDateSold()}</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToBid">
	<input type = "submit" value = "add" name="doThisToBid">
	</form>
</body>
</html>