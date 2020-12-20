<h1> E-shop Products</h1>

<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#dccd">
		<tr>
		<!--  <th>Customer_id</th>-->
			<th>Product</th>
			<th>Price</th>
			
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody>

	<c:forEach items="${productList}" var="product">
			<c:url var="editUrl" value="/product/geteditproduct?prodid=${product.prodid}" />
			<c:url var="deleteUrl" value="/product/deleteproduct?prodid=${product.prodid}" />
			<c:url var="addUrl" value="/product" />
		<tr>

		
			<td><c:out value="${product.name}"/></td>
			<td><c:out value="${product.price}"/></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
		</tr>
	</c:forEach>

	</tbody>
</table>