var divHide=document.getElementByID("navbtn");
divHide.style.display='none';
var app1=angular.module('selectApp',['ngSanitize'])
app1.controller("selectCtrl",function($scope,$http,$window,$sce){
	$http.get('./getData.html').then(
			function(response){
				$scope.reports=response.data;
			});
			$scope.errorShow=true;
			$scope.alertClass='alert alert-danger';
			$scope.navbarButtonClass='btn btn-sm btn-primary';
			getCSS();
			$scope.getTable = function(report){
				$http({
					method: 'GET',
					url:'./getReport.html',
					param: {
						report:report
					}
				}).then(
						function (response){
							if(typeof (response.data)=='string'){
								$scope.errorMessage=response.data;
								$scope.table="";
								$scope.errorShow=false;
							}else{
								if(response.data.hasOwnProperty("UNSCEENAPPLICATIONS")){
									$scope.errorMessage="Details for these"+response.data.UNSCEENAPPLICATIONS+"applications are not present in the people Mapping file";
									$scope.errorShow=false;
								}
								else{
									$scope.errorMessage="";
									$scope.errorShow=true;
								}
								$scope.jason=response.data;
								$scope.openItems=$scope.json.OPENITEM;
								$scope.headerNames=$scope.json.HEADERNAMES;
								if (angular.equals(report,$scope.reports[0])){
									$scope.priorityResponse=$scope.json.PRIORITYRESPONSETIME;
									$scope.priorityResolution=$scope.json.PRIORITYRESOLUTIONTIME;
									var table="<table><thead><tr>";
									angular.forEach ($scope.headerNames,function(value,key){
										table=table+"<th>"+value+"<th>";
									});
									
									table=table+"</tr></thead></tbody>";
									angular.forEach($scope,openItems,function(openItem)
											{
										table=table+"<tr>";
										$scope.priority=openItem[$scope.json.PRIORITYCOLUMNNAME];
										angular.forEach($scope.headerNames,function(value,key){
											if (angular.equals(value,$scope.jason.OPENDAYSHEADER)){
												$scope.getPriority();
												if (parseInt($scope,responseTime,10)>parseInt(openItem[value],10)){
													table = table + "<td class='within'>" + openItem[value] + "</td>";
												}
												else if ( parseInt($scope.resolutionTime,10) < parseInt(openItem[value],10)){
													table = table + "<td class='without'>" + openItem[value] + "</td>";
													
												}else
													table = table + "<td class='btw'>" + openItem[value] + "</td>";
											}else
											table = table + "<td>" + openItem[value] + "</td>";
										});
										
										table = table + "</tr>";
										
											}
									);
									$scope.table = table + "</tbody></table>";
								} else {
									var table = "<table><thead><tr>";
									angular.forEach ( $scope.headerNames, function(value,key){
										table = table + "<th>" + value + "</th";
									});
									
									table = table + "</tr></thead><tbody>";
									
									angular.forEach($scope.openItems,function(openItem){
										table = table + "<tr>";
										angular.forEach($scope.headerNames,function(value,key){
											if (angular.equals(value,$scope.json.OPENDAYSHEADER)){
											if (parseInt(openItem[0],10)>7){
													table = table + "<td class='clr'>" + openItem[value] + "</td>";
												} else 	
													table = table + "<td>" + openItem[value] + "</td>";
											}else 	
												table = table + "<td>" + openItem[value] + "</td>";
										});
										table = table + "</tr>";
									});
									$scope.table = table + "</tbody></table>";
								}
							}
							divHide.style.display='block';
						});
			}
			$scope.getPopUp = function (event){
				window.CertValues = {
						table : $scope.table,
						toAddress : $scope.getAddress($scope.json.TOADDRESS),
						ccAddress : $scope.getAddress($scope.json.CCADDRESS),
						subject : $scope.json.SUBJECT,
						bodyContent : $scope.getBodyConytent()
				};
				window.open("./popup.html","copy of Report","width=850,height=600,left=10,top=150,scrollbars=yes,status=yes,resizable=yes");
			};
			
			$scope.getPriority = function(){
				var responses = $scope.PriorityResponse.split(',');
				var resolution = $scope.PriorityResolution.split(',');
				for(var i = 0; i < responses.length; i++){
					if (angular.equals($scope.priority, response[i].split(':')[0])){
						$scope.responseTime = responses[i].split(':')[1];
					}
				}
				for(var i = 0; i < resolution.length; i++){
					if (angular.equals($scope.priority, resolution[i].split(':')[0])){
						$scope.resolutionTime = resolution[i].split(':')[1];
					}
				}
			}
$scope.sendMail = function (){
	$scope.getSignature();
	try {
		var outlookApp = new ActiveXObject ("Outlook.Application");
		var nameSpace = outlookApp.getNameSpace("MAPI");
		mailFolder = nameSpace.getDefaultFolder(6);
		mailItem = mailFolder.Items.add('IPM.Note.fromA');
		mailItem.Subject = $scope.json.SUBJECT;
		mailItem.To = $scope.getAddress($scope.json.TOADDRESS);
		console.log($scope.style);
		$scope.mailContent = $scope.style +$scope.getBodyContent() + $scope.table+$scope.signature;
		mailItem.HTMLBody = $sce.trustAsHtml($scope.mailContent);
		mailItem.CC = $scope.getAddress ($scope.json.CCADDRESS);
		mailItem.display(0);
	} catch(e){
		$scope.getPopUp();
	}
}

function getCSS(){
	$http.get('./resources/CSS/Welcome.css').then( function (response){
		$scope.style = "<style type=\"text/css\">" + response.data + "</style>"
	});
}

$scope.getAddress= function (address) {
	address = address.replace('[','');
	address = address.replace(']','');
	var add =  addArray[0];
	for (var i=1; i < addArray.length;i++){
		add = add + ";" +addArray[i];
	}
	return add;
}
$scope.getBodyContent=function(){
	content="<p align=\"left\">Hi All,</p><br><p align=\"left\">" +$scope.json.BODYCONTENT+"</p></b><br>";
	return content;
}

$scope.getSignature=function(){
	sign="<br><b><p align=\"left\">Thanks & Regards, </p><p align=\"left\">"+$scope.json.MAILSENTBY+"</p></b><br>";

if(!$scope.json.MAILSENTBYTEAM==''){
	mailSentByTeam=$scope.json.MAILSENTBYTEAM.split(";");
	for (i=0; i< mailSentByTeam.length;i++){
		sign = sign + +"<p align=\"left\">" + mailSentByTeam[i] + "</p>";
	}
}
sign=sign+"<br>";

if(!$scope.json.MAILINGLOCATION==''){
	mailSentByLocation=$scope.json.MAILINGLOCATION.split(";");
	for (i=0; i< mailSentByLocation.length;i++){
		sign = sign + +"<p align=\"left\">" + mailSentByLocation[i] + "</p>";
	}
}
sign=sign+"<br>";
if (!$scope.json.MAILERTEL==''){
	sign = sign + "<p align=\"left\"> Tel: " + $scope.json.MAILERTEL + "</p>";
}
if (!$scope.json.MAILERMOBILE==''){
	sign = sign + "<p align=\"left\"> Mobile: " + $scope.json.MAILERMOBILE + "</p>";
}
if (!$scope.json.MAILID==''){
	sign = sign + "<p align=\"left\"> Email: " + $scope.json.MAILID + "</p>";
}
if (!$scope.json.MAILERDEFAULTNOTE==''){
	mailerDefaultNote=$scope.json.MAILERDEFAULTNOTE.split(";");
	for (i=0; i< mailerDefaultNote.length;i++){
		sign = sign + "<p align=\"left\"> Email: " + mailerDefaultNote[i] + "</p>";
}}
$scope.signature=sign;
};

});