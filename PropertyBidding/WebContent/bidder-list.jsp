<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Bidders</title>
</head>
<body>
	<form method = "post" action = "bidderNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allBidders}" var="currentbidder">
		<tr> 
			<td><input type="radio" name="id" value="${currentbidder.id}"></td>
			<td>Bidder:  ${currentbidder.getName()}</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToBidder">
	<input type = "submit" value = "add" name="doThisToBidder">
	</form>
</body>
</html>