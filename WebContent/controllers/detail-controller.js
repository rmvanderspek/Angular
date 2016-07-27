angular.module("AMail").controller("DetailCtrl", function($scope, $routeParams) {
	$scope.message = messages[$routeParams.id];
});