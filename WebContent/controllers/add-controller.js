angular.module("AMail").controller("AddCtrl", ["$scope", "$location", "$filter",
    function($scope, $location, $filter) {
		$scope.navigate = {};
		$scope.navigate.back = function() {
			$location.path(".//");
		}
		
		$scope.action = {};
		$scope.action.add = function() {
			var message = {};
			message.date = $filter('date')(new Date(), "MMM d, yyyy HH:mm:ss");
			messages.splice(0,0,{
				id: $scope.action.getNewId(), sender: $scope.sender, subject: $scope.subject,
				date: message.date, recipients: [$scope.reciever],
				message: $scope.message
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
			for(var i = 0; i < messages.length; i++) {
				if(messages[i].id > highestId) {
					highestId = messages[i].id;
				}
			}
			return highestId + 1;
		}
	}
]);