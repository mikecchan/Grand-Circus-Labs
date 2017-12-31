<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<c:forEach var="myVar" items="${cList}">
			<tr>
				<td>${myVar.productID}</td>
				<td>${myVar.type}</td>
				<td>${myVar.flavor}</td>
				<td>${myVar.listprice}</td>
				<td><a href="edit?id=${myVar.productID}"> Edit </a></td>
				<td><a href="delete?id=${myVar.productID}"> Delete </a></td>
			</tr>
		</c:forEach>

	</table>
	
	<form action="AddItem" method="get">
		<input type="text" name="product"> <input type="submit">
	</form>
	

</body>
</html>