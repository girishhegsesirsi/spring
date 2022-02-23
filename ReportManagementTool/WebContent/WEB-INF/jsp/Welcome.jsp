<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="selectApp" ng-controller="selectCtrl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Management Tool</title>
<link rel="stylesheet" 
href="<c:url value='/resources/CSS/welcome.css'></c:url>">
<link rel="stylesheet" 
href="<c:url value='/resources/CSS/bootstrap.min.css'></c:url>">
</head>

<body class="tab">
<script type="text/javascript"
src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript"
src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
src="<c:url value="/resources/js/angular.min.js"/>"></script>
<script type="text/javascript"
src="<c:url value="/resources/js/angular-sanitize.min.js"/>"></script>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse"
data-target="#myNavbar">
<span class="sr-only">Toggle Navigation</span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
<a class="nav-brand" href="./">${HeaderMessage}</a>
</div>
<div class="navbar navbar-collapse id="myNavbar">
<ul class="nav navbar-nav navbar-left">
<li class="dropdown"><a class="dropdown-toggle"
data-toggle="dropdown" href="#">Choose a record
<span class="caret"></span></a>
<ul class="dropdown-menu">
<li ng-repeat="report in reports">
<a><span ng-click="getTable(report)">{{report}}</span></a></li>
</ul>
</li></ul>
<form class="navbar-form nav-left">
<div class="form-group" id="navbtn">
<button ng-class="navbarButtonClass" type="button" value="sendMail" ng-click="sendMail()">
Send Report</button>
</div></form>
<ul class="nav navbar-nav navbar-right" style="color:white;">
<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Contact</a>
<ul class="dropdown-menu">
<div class="container-fluid">
<div class="form-group" style="color: black;width: 300px;">
<label>For any application Releated query reach out to the developer</label>
<div class="divider"></div>
<a href="mailto:girishhegdesirsi@gmail.com?subject=Issue%20With%20Report%20Management%20Tool">girishhegdesirsi@gmail.com</a>
</div>
</div></ul>
</li>
<li><a href="#" data-toggle="model" data-target="#myModel">About</a></li>
<li><a href="#"></a></li>
</ul>
</div>
</nav>
<div class="container">
<div ng-hide="errorShow" ng-class="alertClass">
<span ng-bind="errorMessage"></span>
</div></div>
<span ng-bind-html="table"></span>

<div id="myModal" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
<div class="modal-content">
<div class="model-header">
<button type=button" class="close" data-dismiss="modal">&times;</button>
<div class="modal-title">Report Management Tool</div>
</div>
<div class="bs-example bs-example-tabs">
<ul id="myTab" class="nav navtabs">
<li class="active"><a href="#about" data-toggle="tab">About</a></li>
<li><a href="#settings" data-toggle="tab">Browser Settings</a></li>
</ul>
</div>
<div class="modal-body">
<div class="tab-content">
<div class="tab-pane fade active in" id="about">
<div class="row">
<div class="col-xs-12">
<strong><u>About</u></strong>
</div></div>
</div></div></div>
<div class="row">
<div class="col-xs-12">
this tool is used to send out the incident, problem, work request reports on a weakly basis for LASER L3 SUPPORT INFOSYS
</div></div>
<br><br><br><br>
</div>
<div class="row">
<div class="col-xs-12">IE Browser ActiveX setting</u></strong>
</div>
</div>
<br>

<div class="row">
<div class="col-xs-12">
<label>Step 1:</label>
<p>Go To<strong>Browser Settings-> Internet Options -> Security Tab -></strong> Click on <strong>Custom Level</strong>button</p>
</div>
</div>
<div class="row">
<div class="col-xs-12">
<img class="img-responsive"alt="screenshot-1" src="<c:url value="/resources/images/Capture-1.png"/> width="35%" height="35%"></form>
</div>
</div>
</div>
</div>
<script type="text/javascript" src="<c:url value="/resource/js/fetchTable.js"/>" ></script>
</body>
</html>