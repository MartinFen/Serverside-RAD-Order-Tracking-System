<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Products</h1>
<table>
	<tr>
		<th>ID</th>
		<th>Description</th>
		<th>Quantity</th>
	</tr>
	<tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.pId}</td>
				<td>${product.pDesc}</td>
				<td>${product.qtyInStock}</td>
			</tr>
		</c:forEach>
	</tr>
</table>