/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var role = "";
	var usrid = 0;
	function sessionData(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState ==4 && this.status ==200){
			var obj = JSON.parse(xhttp.responseText);
			console.log(obj[0]);
			role = obj[0].role;
			usrid = obj[0].usrid;
			if(role ==="admin"){
			document.getElementById("siteAddress").style.display = "none";
			}else{
			document.getElementById("siteAddress").style.display = "block";
			document.getElementById("guardManage").style.display = "none";
			document.getElementById("clientRequest").style.display = "none";
			document.getElementById("siteManagement").style.display = "none";
			document.getElementById("billDetail").style.display = "none";
			
			}
		}
	};
	xhttp.open("GET","/getSession",true);
	xhttp.send();
	}

var myApp = angular.module('myApp', ['ui.router', 'angucomplete-alt']);
myApp.config(function ($stateProvider, $urlRouterProvider) {
//     $urlRouterProvider.otherwise('');
    $stateProvider
            .state('guardManagement', {
                url: '/guardManagement',
                controller: 'GuardManagementController',
                templateUrl: 'guardManagement.html'
            })
            .state('clientRequest', {
                url: '/clientRequest',
                controller: 'clientRequestController',
                templateUrl: 'clientRequest.html'

            })
            .state('siteManagement', {
                url: '/siteManagement',
                controller: 'siteManagementController',
                templateUrl: 'siteManagement.html'

            })
             .state('billDetail', {
                url: '/billDetail',
                controller: 'billDetailController',
                templateUrl: 'billDetail.html'
            
            }).state('siteAddress',{
                url:'/siteAddress',
                controller:'siteAddressController',
                templateUrl:'siteAddress.html'
            }).state('imageupload',{
                url:'/imageupload',
                controller:'imageuploadController',
                templateUrl:'imageupload.html'
            })
            
    
});


//  addVehicleInfoController

myApp.controller('GuardManagementController', function ($scope, $http, $window) {
	
	
	$scope.clear = function(){
		console.log("helolo");
		 $scope.g_name=	"";		 
	     $scope.mobile_num=	"";	     
	    $scope.address="";
	    $scope.email="";
	     $scope.salary= "";	
	}
	
	$scope.getGuardInfo = function(){
		
		$http.get("/GuradRest/getGuardInfo").then(function(response){
			console.log(response);
			$scope.guardObj = response.data;
			$scope.lengthObj = response.data.length;
		})
	}
	
	$scope.deleteRecord = function(gid){
		console.log("hukgigig");
		console.log(gid +"hhh");
		$http.get("/GuradRest/deleteGuard",{params:{gid :gid}}).then(function(response){
			
			if(response.data === true){
				alert("Data Deleted.")
				$scope.clear();
				$scope.getGuardInfo();
			}else{
				alert("Failed to delete");
			}
		})
	}
	
	$scope.submitGuard = function(){
		var data = {						
				 g_name:$scope.g_name,			 
			     mobile_num:$scope.mobile_num,		     
			    address:$scope.address,
			     email:$scope.email,
			     set_salary:$scope.salary			
		};
		
		$http.post("/GuradRest/setGuard",data).then(function(response){
			console.log(response);
			if(response.data === true){
				alert("Data Saved.")
				$scope.clear();
				$scope.getGuardInfo();
			}else{
				alert("Failed to save");
			}
		})
		
		}
	
	
	$scope.getGuardInfo();
	
})

.controller('siteAddressController', function ($scope, $http, $window) {
	
	console.log(role);
	console.log(usrid);
	$scope.getBill = function(){
		$scope.bill = $scope.tot_guards * $scope.days * 1000;
		console.log($scope.bill );
	}
	
	$scope.clear = function(){
		$scope.siteAddress="";
		$scope.tot_guards = "";
		document.getElementById("req_date").value ="";
		 $scope.days ="";
		 $scope.bill = "";
		
	}
	
	$scope.setClientreq = function(){
	var data = {			
			 address : $scope.siteAddress,
			 tot_guard:$scope.tot_guards,
			 req_on_date : document.getElementById("req_date").value,
			 days:$scope.days,
			 bill:$scope.bill,
			 client_id:usrid,
			 bill_status:'Not Paid',
			 g_set_status:0
	}
	$http.post("/ClientReqRest/setClientReq",data).then(function(response){
		if(response.data === true){
			alert("Your Request is saved ."+" The service will provide you on "+document.getElementById("req_date").value+ " with "+$scope.tot_guards+ " Guards for "+$scope.days+" days.");
			$scope.clear();
		}else{
			alert("Failed to save");
		}
	})
	
	}
	
})

.controller('clientRequestController', function ($scope, $http, $window) {
	
	document.getElementById("clientRequests").style.display="block";
	document.getElementById("setClient").style.display="none";
	
	$scope.clear = function(){
		$scope.username = "";
		$scope.address = "";
		$scope.req_on_date = "";
		$scope.days = "";
		$scope.bill = "";
		$scope.req_id = "";
		$scope.setDetail = [];
	};
	
	$scope.onload = function(){
		
		$http.get("/ClientReqRest/getClientRequest").then(function(response){
			console.log(response);
			$scope.clientReqObj = response.data;
			console.log(response.data);
			$scope.lengthObj = response.data.length;
		})			
	};
	
	$scope.detailToSetGuard = function(username,address,req_on_date,days,bill,req_id){
		
		console.log(username,address,req_on_date,days,bill);
		$scope.username = username;
		$scope.address = address;
		$scope.req_on_date = req_on_date;
		$scope.days = days;
		$scope.bill = bill;
		$scope.req_id = req_id;
		$scope.setDetail = [];
		
		document.getElementById("setClient").style.display="block";
		document.getElementById("clientRequests").style.display="none";
		console.log(document.getElementById("clientRequest").style.display);
	}
	
	$scope.onload();
	
	$http.get("/GuradRest/getGuardInfo").then(function(response){
		//console.log(response);
		$scope.guardObj = response.data;
		//$scope.lengthObj = response.data.length;
	})
	
	var j = 0;
	$scope.onChangeSetDetail = function(){
		console.log($scope.g_name);
		$scope.setDetail.push({"guard_name":$scope.g_name,"req_id":$scope.req_id});
	}
	
	$scope.SetGuards= function(){
		$http.post("/GuardSetRest/setGuards",$scope.setDetail).then(function(response){
			if(response.data == true){
				alert(" Guard has been set. please check on site management report");
				$scope.clear();
				$scope.onload();
				document.getElementById("setClient").style.display="none";
			}else{
				alert("Failed to save.");
			}
		})
	}
	
})

.controller('siteManagementController', function ($scope, $http, $window) {
	
	console.log("in siteManagementController");
	
$scope.onload = function(){
	
	$http.get("/ClientReqRest/getClientRequestSet").then(function(response){
		console.log(response);
		$scope.clientReqObj = response.data;
		console.log(response.data);
		$scope.lengthObj = response.data.length;
	})	
}
$scope.onload() ;
})

.controller('billDetailController', function ($scope, $http, $window) {

	console.log("in siteManagementController");
	
$scope.onload = function(){
	
	$http.get("/ClientReqRest/getClientRequestSet").then(function(response){
		console.log(response);
		$scope.clientReqObj = response.data;
		console.log(response.data);
		$scope.lengthObj = response.data.length;
	})	
}

$scope.updateRecord = function(req_id){
	
	$http.get("/ClientReqRest/updateStatus",{params:{req_id:req_id}}).then(function(response){
		if(response.data === true){
			alert("Bill Paid");
			$scope.onload();
		}
	})	
}


$scope.onload() ;
})

  .directive('fileModel', ['$parse', function ($parse) {
            return {
               restrict: 'A',
               link: function(scope, element, attrs) {
                  var model = $parse(attrs.fileModel);
                  var modelSetter = model.assign;
                  
                  element.bind('change', function() {
                     scope.$apply(function() {
                        modelSetter(scope, element[0].files[0]);
                     });
                  });
               }
            };
         }])
//         .service('fileUpload', ['$http', function ($http) {
//            this.uploadFileToUrl = function(file, uploadUrl) {
//               var fd = new FormData();
//               fd.append('file', file);
//            
//               $http.post(uploadUrl, fd, {
//                  transformRequest: angular.identity,
//                  headers: {'Content-Type': undefined}
//               })
//               .success(function() {
//               })
//               .error(function() {
//               });
//            }
//         }])
         .controller('imageuploadController', function($scope,$http) {
            $scope.uploadFile = function() {
               
               var file = $scope.myFile;
               console.log('file is ' );
               console.log(file);
               var bean = new FormData();
               bean.append('file', file);
//               $http.post("/FileUploadRest/uploadImage",fd,transformRequest: angular.identity,headers: {'Content-Type': undefined}).then(function(response){
//            	   if(response.data == "true" || response.data == true){
//            		   alert("image uploaded");
//            	   }else{
//            		   alert("falied to upload");
//            	   }
//               })
               
               
                 $http.post("/FileUploadRest/uploadImage", bean, {
                  transformRequest: angular.identity,
                  headers: {'Content-Type': undefined}
               })
               .success(function() {
            	   alert("heloo");
               })
               
              
            };
         });
         

