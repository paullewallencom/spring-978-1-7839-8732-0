<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Customer</title>
</head>
<body>
<ul>
<li><a href="product">Product</a>
</li>
<li><a href="order">order</a>
</li></ul>
<c:set var="customer"  value="${customerAttribute}"/>

<h1>Edit Customer</h1>
<c:url var="updateUrl" value="/Spring4MongoDB_Chapter1/customer/update" />
<form method="post" action="/Spring4MongoDB_Chapter1/customer/update">
	<table>
		<tr>
			<td><label path="address">cust_id:</label></td>
			<td>
				<input type="text" readonly name="cust_id" value="${customer.cust_id}"/>
			</td>
		</tr>
		<tr>
					<td><label path="name"> Name:</label></td>
			<td><input type="text" name="name" value="${customer.name}"/></td>
		</tr>
		<tr>
			<td><label path="address">Address:</label></td>
			<td><input  type="text" name="address" value="${customer.address}"/></td>
		</tr>

	</table>

	<input type="submit" value="update" />
</form>
<%@ include file="allcustomers.jsp" %>

</body>
</html>
