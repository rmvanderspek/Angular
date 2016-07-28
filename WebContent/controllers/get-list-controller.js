angular.module("AMail").controller("getListCtrl", ["$scope", "$http",
   function MyController($scope, $http) {

    $scope.items = [];
    $scope.getItems = function() {

        $http({method : 'GET', url : "http://localhost:8080/Angular/resources/list"})
            .success(function(data, status) {
                $scope.items = data;
            })
            .error(function(data, status) {
                alert("Error");
            });
    }}
    ]);