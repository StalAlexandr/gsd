var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http, $element) {

    $scope.network = {};

    $scope.application={};

    $scope.selectedExtidappli = '';

    $scope.selectedOperation = {};

    $scope.getApplication = function(){
        $http.get('http://localhost:9000/api/application/'+$scope.selectedExtidappli).then(function (response) {

            if (!response.data.id){
                alert('Заявка не найдена');
                return;
            }

            $scope.application = response.data;
        });
    }

    $scope.selectStatus = function(status, nextLink) {
      console.log(status);
      $scope.selectedOperation = nextLink.operation;
      $scope.$apply();
    }

    $scope.selectOperation = function(operation) {
      $scope.selectedOperation = operation.operation;
      $scope.$apply();
    }

    $scope.init = function () {

        var nodesList = [];

        var fromList = [];

        $http.get('http://localhost:9000/api/network').then(function (response) {
            var data = response.data;

            var nodes = []
            var links = []

            data.forEach(function (d) {
                nodes.push({
                    id: d.id,
                    label: d.status.name,
                    x: d.position.xposition + 50,
                    y: d.position.yposition,
                })
                d.from.forEach(function (j) {
                    links.push({
                        arrows: 'to',
                        id: j.id,
                        from: j.from,
                        to: j.to,
                        label: j.operation.code,
                        operation: j.operation
                    });
                })
            })
            $scope.network = {nodes: nodes, links: links}
            $scope.$apply;
        });
    }
});

