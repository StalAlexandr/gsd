var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http, $element) {
    $scope.firstName= "John";
    $scope.lastName= "Doe";
    $scope.init = function () {

        var nodesList = [];
        var fromList = [];

        $http.get('http://localhost:9000/api/vertex').
        then(function(response) {
            var data = response.data;

            for(var i in data)
            {
                var node = {id:data[i].id, label: "Node" + data[i].id, x:data[i].position.xposition, y:data[i].position.yposition};
                var elementFrom = data[i].from;
                for(var j in elementFrom){
                    var currentFrom = {from:elementFrom[j].from, to:elementFrom[j].to};
                    fromList.push(currentFrom);
                }
                nodesList.push(node);
            }

            var nodes = new vis.DataSet(nodesList);
            var edges = new vis.DataSet(fromList);
            var container =  document.querySelector('#mynetwork');
            var data = {
                nodes: nodes,
                edges: edges
            };
            var options = {};
            var network = new vis.Network(container, data, options);
        });

	}

});

