<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Registration is failed. Please try again.</p>

<form action="RegValidation">

<label>Enter Account Number :</label>
<input type="text" name="accno"> </br></br>

<label>Enter Name :</label>
<input type="text" name="name"> </br></br>

<label>Enter Password :</label>
<input type="text" name="pass"> </br></br>

<label>Enter Email Id :</label>
<input type="text" name="email"> </br></br>

<label>Enter Balance :</label>
<input type="text" name="balance"> </br></br>

<input type="submit" value="Register">

</form>
</body>
</html>