/**
 * 
 */
var app=angular.module("myApp",['ngSanitize']);
app.controller("myCtrl",function($scope,$window){
	$scope.table=window.opener.Certvalues.table;
	$scope.bodyContent=window.opener.Certvalues.bodyContent;
	var to=window.opener.Certvalues.toAddress;
	var cc=window.opener.Certvalues.ccAddress;
	var subject=window.opener.Certvalues.subject;
	window.onbeforeunload=function(){
		window.open("mailto:" + to + "?subject=" + subject + "&cc=" +cc);
	}
})