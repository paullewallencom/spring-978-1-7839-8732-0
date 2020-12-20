<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Customer</title>
</head>
<body>

<h1>Register Customer</h1>
<ul>
<li><a href="/Spring4MongoDB_Chapter1/product">Product</a>
</li>
<li>Order<a href="/Spring4MongoDB_Chapter1/order">order</a>
</li></ul>
<form  method="post" action="/Spring4MongoDB_Chapter1/customer/save">
	<table>
		<tr>
			<td> Name:</td>
			<td><input type=text name="name"/></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type=text name="address"/></td>
		</tr>
			</table>
	<input type="hidden" name="cust_id"  >
	<input type="submit" value="Save" />
</form>

<%@ include file="allcustomers.jsp" %>

</body>
</html>
