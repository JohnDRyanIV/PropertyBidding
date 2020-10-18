<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Properties</title>
</head>
<body>
	<form method = "post" action = "propertyNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allProperties}" var = "currentProperty">
				<tr>
					<td><input type="radio" name="id" value="${currentProperty.id}"></td>
					<td>Address: ${currentProperty.getAddress() }</td>
					<td>${currentProperty.getCity()}</td> <!-- city -->
					<td>${currentPropety.getState()}</td> <!-- state -->
					<td>${currentProperty.getZip()}</td> <!--  zipcode -->
					<td>${currentProperty.showDateSold()}</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name = "doThisToProperty">
		<input type = "submit" value = "add" name = "doThisToProperty">
		<input type = "submit" value = "delete" name = "doThisToProperty">
		<input type = "submit" value = "sell" name = "doThisToProperty">
		<!-- implement placing bids on selected property later -->
	</form>

</body>
</html>