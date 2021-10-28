<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>New Password and Confirm New Password fields are not matching.Try again.</p>
<form action="ChangePwdValidation">
<label>Old Password</label>
<input type="text" name="opwd"><br><br>

<label>New Password</label>
<input type="text" name="npwd"><br><br>

<label>Confirm New Password</label>
<input type="text" name="cnpwd"><br><br>

<input type="submit" value="ChangePassword">

</form>
</body>
</html>