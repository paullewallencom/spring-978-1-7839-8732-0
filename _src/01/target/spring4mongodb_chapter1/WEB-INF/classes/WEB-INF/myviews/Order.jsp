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

<h1>Orders </h1>
<ul>
<li><a href="/Spring4MongoDB_Chapter1/customer">Customer</a>
</li>
<li>r<a href="/Spring4MongoDB_Chapter1/product">Product</a>
</li></ul>

<form:form action="/Spring4MongoDB_Chapter1/order/save" modelAttribute="Order"> 	
	<table>
		<tr>
			<td>Add your Order:</td>
                        <td><form:input path="quantity" size="3"/></td>
		</tr>
		<tr>
			<td>Select Product:</td>
			<td> 
				<form:select path="product.prodid">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${productList}" itemValue="prodid" itemLabel="name"/>
        		</form:select>
			</td>
		</tr>	
		<tr>
			<td>Select Customer:</td>
			<td> 
				<form:select path="customer.cust_id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${customerList}" itemValue="cust_id" itemLabel="name"/>
        		</form:select>
			</td>
		</tr>			
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Submit" />	
			</td>
		</tr>
	</table>
</form:form>

<%@ include file="allorders.jsp" %>
</body>
</html>
