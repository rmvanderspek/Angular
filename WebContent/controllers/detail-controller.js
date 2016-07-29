angular.module("AMail").controller("DetailCtrl", function($scope, $routeParams) {
	$scope.id = $routeParams.id - 1;
	$scope.item = items[$scope.id];
	
	
   
});