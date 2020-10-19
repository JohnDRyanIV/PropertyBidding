<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	TODO: add some standard real estate website page header
	<p></p> <!-- line break -->
	<a href = "new-bidder.jsp"><button>Add a bidder</button></a></br>
	<a href = "viewAllBiddersServlet"><button>View all bidders</button></a>
	<p></p><!-- line break -->
	<a href = "new-property.jsp"><button>Add a property</button></a><br/>
	<a href = "viewAllPropertiesServlet"><button>View all properties</button></a>
	<p></p><!-- line break -->
	<form method = "post" action = "navigationServlet">
		<input type = "submit" value = "Add a bid" name = "doThisToBid">
	</form>
	<a href = "viewAllBidsServlet"><button>View all bids</button></a>
</body>
</html>