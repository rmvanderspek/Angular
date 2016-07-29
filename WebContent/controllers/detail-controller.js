angular.module("AMail").controller("DetailCtrl", function($scope, $routeParams) {
	$scope.id = $routeParams.id;
	for (var i = 0; i < items.length; i++){
		if(items[i].id === parseInt($scope.id)){
			$scope.item = items[i];
		}
	}
});