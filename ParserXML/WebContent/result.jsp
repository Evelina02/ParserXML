<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Result of parsing</title>
</head>
<body>
	<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Picture</th>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
				<th scope="col">Category</th>
				<th scope="col">Amount</th>
				<th scope="col">Ingredients</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.dishes}" var="dish">
				<tr>
					<td>
						<img src="${dish.picture}" alt="" style="width: 100%; height: 100%;">
					</td>
					<td>${dish.id}</td>
					<td>${dish.name}</td>
					<td>${dish.price}</td>
					<td>${dish.category}</td>
					<td>${dish.amount}</td>
					<td><c:forEach items="${dish.ingredients}" var="ingredient">
							<ul>
								<li>${ingredient}</li>
							</ul>
						</c:forEach></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<br><br>
<a href="${pageContext.request.contextPath}/index.jsp">Home page</a>
</body>
</html>