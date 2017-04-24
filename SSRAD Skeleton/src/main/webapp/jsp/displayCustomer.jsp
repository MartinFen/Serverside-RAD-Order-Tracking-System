<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
</head>
<body>
	<c:forEach items="${customers}" var="customer">
	<br>
	<h1>${customer.cId} ${customer.cName}</h1>
	<br>
	<h2>${customer.cName}'s Orders</h2>
	<table>
		<tr>
			<th>Order ID</th>
			<th>Quantity</th>
			<th>Product ID</th>
			<th>Product Description</th>
		</tr>
		<tr>
			<c:forEach items="${customer.orders}" var="order">
				<tr>
					<td>${order.oId}</td>
					<td>${order.qty}</td>
					<td>${order.prod.pId}</td>
					<td>${order.prod.pDesc}</td>
			</c:forEach>
		</tr>
	</table>
	</c:forEach>
</body>
</html>