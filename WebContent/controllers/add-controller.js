angular.module("AMail").controller("AddCtrl", ["$scope", "$location",
    function($scope, $location) {
		$scope.navigate = {};
		$scope.navigate.back = function() {
			$location.path(".//");
		}
		
		$scope.action = {};
		$scope.action.add = function() {
			messages.push({
				id: getNewId(), sender: $scope.sender, subject: $scope.subject,
				date: 'Dec 7, 2013 12:32:00', recipients: [$scope.reciever],
				message: $scope.message
			});
		}
		
		var getNewId = function() {
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