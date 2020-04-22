<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Parse your XML</title>
</head>
<body>


<c:if test="${not empty requestScope.errorMessage}">
	<c:out value="${errorMessage}"></c:out>
</c:if>

	<form action="${pageContext.request.contextPath}/Controller" method="post">
		
		Select your XML:<br>
		<input type="file" class="form-control-file" name="fileName">
	<br><br>	
		<div class="btn-group btn-group-lg" role="group">

			<button name="command" value="sax_parser" type="submit"
				class="btn btn-outline-dark">SAX</button>
			<button name="command" value="stax_parser" type="submit"
				class="btn btn-outline-dark">STAX</button>
			<button name="command" value="dom_parser" type="submit"
				class="btn btn-outline-dark">DOM</button>
		</div>
	</form>
</body>
</html>
