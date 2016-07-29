angular.module("AMail").controller("ListCtrl", ["$scope", "$location", "$http",
    function($scope, $location, $http) {
		$scope.navigate = {};
		$scope.navigate.add = function() {
			$location.path("/add");
		};
		
		$scope.navigate.getList = function(){
			$location.path("/getList");
		};
		
		$scope.action = {};
		$scope.action.clear = function() {
			$scope.$parent.succesMessage = "";
		};
		
		$scope.items = items;
		
	    $scope.getItems = function() {

	        $http({method : 'GET', url : "resources/list"})
	            .success(function(data, status) {
	                items = data;
	                $scope.items = data;
	            })
	            .error(function(data, status) {
	                alert("Error");
	            });
	    };
	}
]);