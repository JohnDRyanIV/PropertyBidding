<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Property Bid</title>
</head>
<body>
	<form method = "post" action = "addBidServlet">
	Select a Bidder:
	<table>
	<c:forEach items="${requestScope.selectBidder}" var="currentbidder">
		<tr> 
			<td><input type="radio" name="bidderId" value="${currentbidder.id}"></td>
			<td>Bidder:  ${currentbidder.getName()}</td>
		</tr>
	</c:forEach>
	</table>
	Select a Property:
	<table>
	<c:forEach items="${requestScope.allProperties}" var = "currentProperty">
		<tr>
			<td><input type="radio" name="propId" value="${currentProperty.id}"></td>
			<td>Address: ${currentProperty.getAddress() }</td>
			<td>${currentProperty.getCity()}</td> <!-- city -->
			<td>${currentPropety.getState()}</td> <!-- state -->
			<td>${currentProperty.getZip()}</td> <!--  zipcode -->
			<td>${currentProperty.showDateSold()}</td>
		</tr>
	</c:forEach>
	</table>
	Enter Bid Amount: <input type = "text" name = "bidAmount">
	<input type = "submit" value = "add" name="doThisToBid">
	</form>
</body>
</html>