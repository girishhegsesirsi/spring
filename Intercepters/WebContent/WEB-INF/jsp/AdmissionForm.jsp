<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission form</title>
</head>
<body>
<h1>${headerMessage}</h1>
<h3> STUDENT ADMISSION FORM</h3>
<form:errors path="student1.*"/>
<form action="/Intercepters/SubmissionForm">
<table>
<tr> <td>Student's id: </td><td><input type="text" name="id"/></td></tr>
<tr> <td>Student's name: </td><td><input type="text" name="name"/></td></tr>
<tr> <td>Student's hobby: </td><td><input type="text" name="hobby"/></td></tr>
<tr> <td>Student's mobile: </td><td><input type="text" name="mobile"/></td></tr>
<tr> <td>Student's DOB: </td><td><input type="text" name="DOB"/></td></tr>
<tr> <td>Student's skills: </td>
<td>
<select name="skills" multiple>
<option value="Core Java">Core Java</option>
<option value="Spring MVC">Spring MVC</option>
<option value="Hibernate">Hibernate</option>
<option value="Oracle DB">Oracle DB</option>
</select>
</td></tr>

<tr><td> Students Address</td></tr>
<tr>
<td>Street : <input type="text" name="studentAddress.street"/></td>
<td>City : <input type="text" name="studentAddress.city"/></td>
<td>State : <input type="text" name="studentAddress.state"/></td>
</tr>
<tr><td><input type="submit" value="submit this form"/></td></tr>
</table>
</form>
</body>
</html>