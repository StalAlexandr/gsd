var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $scope.firstName= "John";
    $scope.lastName= "Doe";
    
    $scope.init = function () {
        
        const headers = new Headers();
headers.append('Access-Control-Allow-Headers', 'Content-Type');
headers.append('Access-Control-Allow-Methods', 'GET');
headers.append('Access-Control-Allow-Origin', '*');
        
    $http.get('http://localhost:9090/api/vertex', headers).    
        then(function(response) {
           alert(response.data);
        });
    } 
    
    
    
});

	