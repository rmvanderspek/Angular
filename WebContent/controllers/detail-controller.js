angular.module("AMail").controller("DetailCtrl", function($scope, $routeParams) {
	$scope.id = $routeParams.id;
	for (var i = 0; i < items.length; i++){
		console.log(items.length);
		console.log(items);
		console.log(items[i].id);
		console.log($scope.id);
		if(items[i].id === parseInt($scope.id)){
			$scope.item = items[i];
			console.log($scope.item);
		}
	}
//	$scope.item = items[$scope.id];
});