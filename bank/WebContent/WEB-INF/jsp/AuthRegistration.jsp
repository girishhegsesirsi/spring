<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.owasp.esapi.ESAPI" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AuthRegistration</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">

function getCrontosign(){

	//var url='/bank/getCrontoSign';
	//var url="/bank/crontoSign";
	//var url='/bank/fetchcrontoSignJson';
	var url="/bank/crontoSignArray";
	var autoken='<%=ESAPI.encoder().encodeForHTML("96F15A6D70")%>';
	var srlNumber='<%=ESAPI.encoder().encodeForHTML("FDN6168429")%>';
	//alert("getCronto");	
	$.ajax({
		type: 'POST',
		url:url,
	//	dataType: 'json',
	//	contentType:'application/json; charset=utf-8',
	//	mimeType:'application/json',
		//data: {
	//	aToken:autoken,		
	//		sNumber:srlNumber
	//},
		
		success: function (data1){
			
		//var res = JSON.parse(data);
		//	alert(res); 
		var reg="^[A-Za-z0-9/+=]+$";
		var data = data1[0];
		var image=data.QRImage;
		//8alert(image); 
		
		var res=String(data).match(reg);
		alert(res);
			//document.getElementById("crontoSignImage").src="data:image/png;base64," + data.QRImage;
		document.getElementById("crontoSignImage").src="data:image/png;base64," + res;
		},
		error: function (xhr, ajaxOptions, thrownError){
			alert("error"); 
			document.getElementById("crontoSignImage").src="data:image/png;base64," + xhr.responseText;
			if (xhr.responseText!=null && xhr.status==409){
				var resString = eval ('('+xhr.responseText +')');
			}else {
			$("div#errMsg").css("color","red");
			$("div#errMsg").html(xhr.responseText);
			
			}
		}
	})
	//alert("after getCronto");
}
</script>
</head>
<body>
<button name="" id="cronto" onclick="getCrontosign()">Cronto</button>
<image src="" id="crontoSignImage" alt="" />
<div id="errMsg"></div>
</body>
</html>