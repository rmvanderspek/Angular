angular.module("AMail").controller("DetailCtrl", ["$scope", "$location", "$routeParams", 
    function($scope, $location, $routeParams) {
		$scope.id = $routeParams.id;
		for (var i = 0; i < items.length; i++){
			if(items[i].id === parseInt($scope.id)){
				$scope.item = items[i];
			}
		}
		
		$scope.navigate = {};
		
		$scope.navigate.back = function() {
			$location.path(".//");
		};
	}
]);