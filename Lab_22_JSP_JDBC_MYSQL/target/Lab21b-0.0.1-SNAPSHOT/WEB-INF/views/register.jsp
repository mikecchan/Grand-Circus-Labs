<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<fieldset>
		<legend>Please fill the form to register</legend>
		<!--<form action="/Lab21/addUser" method="post">  -->
		<form id="myForm" method="post">
			First name: <input type="text" id="fname" name="fname"><br>
	  		Last name: <input type="text" id="lname" name="lname"><br>
	  		Email: <input type="text" id="email" name="email"><br>
	  		Phone Number: <input type="text" id="pnum" name="pnum"><br>
	  		Password: <input type="text" id="pword" name="pword"><br>
	  		<input type="submit" value="Submit" onclick="check()">
		</form>
	</fieldset>
	<div id="error_message"></div>
	
<script type='text/JavaScript'>
	function check(){
		console.log("Entering Check()");
		
		var para = document.createElement("p");
		var node = null;
		//var node = document.createTextNode("This is new.");
		var element = document.getElementById("error_message");
		
		var output = "First name is " + document.getElementById("fname").value;
		
		console.log(output);
		
		
		if(	document.getElementById("fname").value == "" ||
			document.getElementById("lname").value == "" ||
			document.getElementById("email").value == "" ||
			document.getElementById("pnum").value == "" ||
			document.getElementById("pword").value == "" )	{
			
			console.log("first if");
			node = document.createTextNode("Please fill in all text boxes.");
			para.appendChild(node);
			element.appendChild(para);
		}
		else if( !document.getElementById("email").value.includes("@")){
			console.log("second if");
			node = document.createTextNode("Please input a proper email address");
			para.appendChild(node);
			element.appendChild(para);
		}
		else if((document.getElementById("pnum").value.length != 10) && (!document.getElementById("pnum").value.match(/^\d+$/)) ){
			console.log("third if");
			node = document.createTextNode("Please enter a proper phone number, 10 numeric digits only");
			para.appendChild(node);
			element.appendChild(para);
		}
		else {
			console.log("success");
			document.getElementById("myForm").action = "/Lab21b/addUser";
		}
		
	}
</script>
</body>
</html>

