<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
</head>
<body>
	<h1>List of Orders</h1>
	<c:forEach items="${orders}" var="order">
		<br>
		<h2>${order.oId}</h2>
		<table>
			<tr>
				<th>Quantity</th>
				<th>Order Date</th>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Product ID</th>
				<th>Product Description</th>
			</tr>
			<tr>
				<c:forEach items="${orders}" var="order2">
					<tr>
						<td>${order2.qty}</td>
						<td>${order2.orderDate}</td>
						<td>${order2.cust.cId}</td>
						<td>${order2.cust.cName}</td>
						<td>${order2.prod.pId}</td>
						<td>${order2.prod.pDesc}</td>
				</c:forEach>
			</tr>
		</table>
	</c:forEach>
</body>
</html>