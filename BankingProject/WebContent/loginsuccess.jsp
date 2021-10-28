<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession hs=request.getSession();
String accno=(String)hs.getAttribute("accno");
String name=(String)hs.getAttribute("name");
out.println("Welcome" + name);
out.println("<br>");
out.println("Account number : "+ accno);


%>
<br><br>
<a href="loan.jsp">Click here to apply loan.</a> <br><br>
<a href="Balance">Click here to Check balance.</a><br><br>
<a href="Changepassword.jsp">Click here to Change password.</a><br><br>
<a href="transfer.jsp">Click here to Transfer Money.</a><br><br>
<a href="logout.jsp">Click here to Logout.</a>

</body>
</html>