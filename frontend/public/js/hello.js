var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $scope.firstName= "John";
    $scope.lastName= "Doe";
    $scope.init = function () {

    $http.get('http://localhost:9000/api/vertex').    
        then(function(response) {
           alert(response.data);
        });
    } 
    
    
});

