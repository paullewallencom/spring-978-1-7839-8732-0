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
<li><a href="customer">Customer</a>
</li>
<li><a href="order">order</a>
</li></ul>
<c:set var="product"  value="${productAttribute}"/>

<h1>Edit Customer</h1>
<c:url var="updateUrl" value="/Spring4MongoDB_Chapter1/product/update" />
<form method="post" action="/Spring4MongoDB_Chapter1/product/update">
	<table>
		<tr>
			<td><label path="address">prodid:</label></td>
			<td>
				<input type="text" readonly name="prodid" value="${product.prodid}"/>
			</td>
		</tr>
		<tr>
					<td><label path="name"> Name:</label></td>
			<td><input type="text" name="name" value="${product.name}"/></td>
		</tr>
		<tr>
			<td><label path="address">price:</label></td>
			<td><input  type="text" name="price" value="${product.price}"/></td>
		</tr>

	</table>

	<input type="submit" value="update" />
</form>
<%@ include file="allproducts.jsp" %>
</body>
</html>
