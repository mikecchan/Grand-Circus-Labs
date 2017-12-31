<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Edit Item</h3>
	<br/>
	<form action="ItemAdmin" method="get">
		Name:<input type = "text" name = "name"/>
		<br />
		Description:<input type = "text" name = "description"/>
		<br />
		Quantity:<input type = "text" name = "quantity"/>
		<br />
		Price:<input type = "text" name = "price"/>
		<br />
		<input type = "submit" name = "submit" />
	</form>
	${error_message }
</body>
</html>