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
		</tr>
	</c:forEach>
	</table>
	Select a Property:
	<table>
	<c:forEach items="${requestScope.allProperties}" var = "currentProperty">
		<tr>
			<td><input type="radio" name="propId" value="${currentProperty.toString()}"></td>
		</tr>
	</c:forEach>
	</table>
	Enter Bid Amount: <input type = "text" name = "bidAmount">
	<input type = "submit" value = "add" name="doThisToBid">
	</form>
</body>
</html>