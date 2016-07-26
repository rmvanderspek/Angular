angular.module("AMail").controller("DetailCtrl", function($scope, $routeParams) {
	console.log($routeParams.id);
	$scope.message = messages[$routeParams.id];
});