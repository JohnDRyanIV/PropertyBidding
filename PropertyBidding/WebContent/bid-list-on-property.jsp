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
	<form method = "post" action = "viewAllBidsOnPropertyServlet">
		<table>
			<c:forEach items = "${requestScope.allBidsOnProperty}" var="currentBid">
				<tr>
					<td>Bidder: ${currentBid.bidder.getName()}</td>
					<td>Bid Amount: $${currentBid.formattedBidAmt()}</td>
					<td>${currentBid.property.getDateSold()}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>