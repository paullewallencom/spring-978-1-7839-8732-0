<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Product</title>
</head>
<body>

<h1>Register Product</h1>
<ul>
<li><a href="/Spring4MongoDB_Chapter1/customer">Customer</a>
</li>
<li>r<a href="/Spring4MongoDB_Chapter1/order">Product</a>
</li></ul>
<form  method="post" action="/Spring4MongoDB_Chapter1/product/save">
	<table>
		<tr>
			<td> Name:</td>
			<td><input type=text name="name"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><input type=text name="price"/></td>
		</tr>
			</table>
	<input type="hidden" name="prod_id"  >
	<input type="submit" value="Save" />
</form>
<%@ include file="allproducts.jsp" %>
</body>
</html>
