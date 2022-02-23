<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
function getImage(){
	//alert("inside getImage()");
	var url="/jQueryMvc/crontoSign";
	$.ajax({
	type: 'POST',
	url:url,
	datatype:"json"
	,
	
	success: function(data){
		alert(data);
		//alert("call is in success");
		var res = JSON.parse(data);
		//alert(res.QRImage);
		document.getElementById("crontoImage").src = "data:image/png;base64,"+data;
	},
	error:function(xhr,ajaxOptions, thrownError){
		alert(" Error Occured");
	}
	
	});
}

function getHardcodedImage(){
	var str = "SGksIHRoaXMgaXMgUVI=";
	document.getElementById("crontoImage").src = "data:image/png;base64,"+str;
}

</script>
</head>

<body>
<form>
<img src="" id="crontoImage" alt="image">
<button type="button" onclick="getImage()">Click me</button>
<button type="button" onclick="getHardcodedImage()">hard coded hex</button>
</form>
</body>
</html>