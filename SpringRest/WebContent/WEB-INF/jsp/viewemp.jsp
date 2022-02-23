<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>$(tittle)</h1>
<form action="save">
<table>
<tr>
<td>name:</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>salary:</td>
<td><input type="text" name="salary"/></td>
</tr>
<tr>
<td>destination:</td>
<td><input type="text" name="destination"/></td>
</tr>
<tr>
<td>course:</td>
<td><select name="course" multiple>
<option>Java</option>
<option>.net</option>
<option>C</option>
</select>
</td>
</tr>
</table></form>
</body>
</html>