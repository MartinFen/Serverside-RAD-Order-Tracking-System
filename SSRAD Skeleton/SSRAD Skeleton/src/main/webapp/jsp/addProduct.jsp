<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
</head>
<body>
	<form:form modelAttribute="product1">
		<h1>Add New Product</h1>
		<br>
		<table>
			<tr>
				<td>Product description:</td>
				<td><form:input path="pDesc"></form:input></td>
				<td><form:errors path="pDesc" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Quantity in stock:</td>
				<td><form:input path="qtyInStock"></form:input></td>
				<td><form:errors path="qtyInStock"></form:errors></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
		<a href="/">Home</a>
		<a href="/showOrders">List Orders</a>
		<a href="/showProducts">List Product</a>
	</form:form>
</body>
</html>