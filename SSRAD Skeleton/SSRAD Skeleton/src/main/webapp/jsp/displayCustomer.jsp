<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
</head>
<body>
	<h1>List of customers</h1>
	${customers.}${customers.}
	<br>
	${customers.}'s Orders
	<table>
		<tr>
			<th>Order ID</th>
			<th>Quantity</th>
			<th>Product ID</th>
			<th>Description</th>
		</tr>
		<tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.cid}</td>
					<td>${customer.}</td>
					<td>${customer.}</td>
					<td>${customer.}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>