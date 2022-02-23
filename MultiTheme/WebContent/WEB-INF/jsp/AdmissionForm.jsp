<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission form</title>
</head>
<body>

<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
<p>
<a href="/MultiTheme/AdmissionForm?siteTheme=red">red</a>
<a href="/MultiTheme/AdmissionForm?siteTheme=green">green</a>
</p>

<a href="/MultiTheme/AdmissionForm?siteLanguage=en">English</a>
<a href="/MultiTheme/AdmissionForm?siteLanguage=ka">Kannada</a>

<h3>${headerMessage}</h3>
<h3> STUDENT ADMISSION FORM</h3>
<form:errors path="student1.*"/>
<form action="/MultiTheme/SubmissionForm">
<table>

<tr> <td><spring:message code="Label.StudentId"/> </td><td><input type="text" name="id"/></td></tr>
<tr> <td><spring:message code="Label.StudentName"/> </td><td><input type="text" name="name"/></td></tr>
<tr> <td><spring:message code="Label.StudentHobby"/> </td><td><input type="text" name="hobby"/></td></tr>
<tr> <td><spring:message code="Label.StudentMobile"/> </td><td><input type="text" name="mobile"/></td></tr>
<tr> <td><spring:message code="Label.StudentDOB"/> </td><td><input type="text" name="DOB"/></td></tr>

<tr> <td><spring:message code="Label.Skills"></spring:message></td>
<td>
<select name="skills" multiple>
<option value="Core Java">Core Java</option>
<option value="Spring MVC">Spring MVC</option>
<option value="Hibernate">Hibernate</option>
<option value="Oracle DB">Oracle DB</option>
</select>
</td></tr>

<tr><td> <spring:message code="Label.Address"></spring:message></td></tr>
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