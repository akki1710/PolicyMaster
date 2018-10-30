<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="rp" class="ServeletBean.RegPJ"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserManag" method="get">
<%rp=(ServeletBean.RegPJ)session.getAttribute( "rp" ); %>
Uname: <input type="text" name="Uname" value="<%=rp.getUname() %>" required=" "/><br>
Name: <input type="text" name="Name" value="<%=rp.getName() %>" required=" "/><br>
City: <input type="text" name="City" value="<%=rp.getCity() %>" required=" "/><br>
Birthdate: <input type="text" name="Birthdate" value="<%=rp.getBirthdate() %>" required=" "/><br>
Email: <input type="text" name="Email" value="<%=rp.getEmail() %>" required=" "/><br>
Phoneno: <input type="text" name="Phoneno" value="<%=rp.getPhoneno()%>" required=" "/><br>
</form>
</body>
</html>