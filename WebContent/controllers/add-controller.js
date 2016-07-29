angular.module("AMail").controller("AddCtrl", ["$scope", "$location", "$filter", "$http",
    function($scope, $location, $filter, $http) {
		$scope.navigate = {};
		$scope.navigate.back = function() {
			$location.path(".//");
		}
		
		$scope.action = {};
		$scope.action.add = function() {
			$http({
			    method : 'POST',
			    url : "http://localhost:8080/Angular/resources/addItem",
			    data : {
			        'sender' : $scope.sender,
			        'receiver' : $scope.receiver,
			        'subject' : $scope.subject,
			        'date' : $scope.date,
			        'message' : $scope.message
			    },
			    headers : {
			        'Content-Type' : 'application/x-www-form-urlencoded'
			    }
			}).success(function (data) {
			    console.log(' data ');
			});
			
			
			
			$scope.action.resetFields();
			$scope.$parent.succesMessage = "Your e-mail is now saved.";
			$location.path(".//");
		}
		
		$scope.action.resetFields = function() {
			$scope.sender = "";
			$scope.subject = "";
			$scope.reciever = "";
			$scope.message = "";
		}
		
		$scope.action.getNewId = function() {
			var highestId = -1;
			for(var i = 0; i < items.length; i++) {
				if(items[i].id > highestId) {
					highestId = items[i].id;
				}
			}
			return highestId + 1;
		}
	}
]);