<h1> E-shop Orders</h1>

<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fffcc">
		<tr>
			<th>Order Id</th>
			<th>Customer Name</th>
			<th>Customer Address</th>
			<th>Product Address</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody>

	<c:forEach items="${orderList}" var="order">
			<c:url var="editUrl" value="/order/geteditorder?order_id=${order.order_id}" />
		<c:url var="deleteUrl" value="/order/deleteorder?order_id=${order.order_id}" />
		<c:url var="addUrl" value="/order/" />	
		<tr>
		<td><c:out value="${order.order_id}" /></td>
			<td><c:out value="${order.customer.name}" /></td>
			<td><c:out value="${order.customer.address}" /></td>
				<td><c:out value="${order.product.name}" /></td>
				<td><c:out value="${order.product.price}" /></td>
				<td><c:out value="${order.quantity}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
		</tr>
	</c:forEach>

	</tbody>