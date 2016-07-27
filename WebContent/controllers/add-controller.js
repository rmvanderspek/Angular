angular.module("AMail").controller("AddCtrl", ["$scope", "$location",
    function($scope, $location) {
		$scope.navigate = {};
		$scope.navigate.back = function() {
			$location.path(".//");
		}
	}
]);