<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	${name}
	<br>
	<fieldset>
		<h2>Please select what you would like to buy...</h2>
		<form action="/Lab21b/checkout" method="post">
			<input type="checkbox" name="item" value="Coffee"> Coffee<br>
  			<input type="checkbox" name="item" value="Cake"> Cake<br>
 			<input type="checkbox" name="item" value="Espresso"> Espesso<br>
	  		<input type="submit" value="Submit" name="Buy">
		</form>
	</fieldset>
</body>
</html>