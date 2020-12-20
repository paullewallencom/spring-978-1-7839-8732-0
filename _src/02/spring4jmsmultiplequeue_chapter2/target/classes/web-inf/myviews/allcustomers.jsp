<h1> E-shop Customers</h1>

<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#dccd">
		<tr>
			<th>Name</th>
			<th>Address</th>
			
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody>

	<c:forEach items="${customerList}" var="customers">
			<c:url var="editUrl" value="/customer/geteditcustomer?cust_id=${customers.cust_id}" />
			<c:url var="deleteUrl" value="/customer/deletecustomer?cust_id=${customers.cust_id}" />
			
		<tr>
			<td><c:out value="${customers.name}" /></td>
			<td><c:out value="${customers.address}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
		</tr>
	</c:forEach>

	</tbody>