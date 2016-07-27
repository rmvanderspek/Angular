angular.module("AMail").controller("ListCtrl", ["$scope", "$location",
    function($scope, $location) {
		$scope.messages = messages;
		$scope.navigate = {};
		$scope.navigate.add = function() {
			$location.path("/add");
		}
		$scope.action = {};
		$scope.action.clear = function() {
			$scope.$parent.succesMessage = "";
		}
	}
]);