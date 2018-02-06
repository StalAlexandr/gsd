var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http, $element) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";

    $scope.doSome = function (text) {
        $scope.someText = text;
        $scope.$apply();
    };

    $scope.init = function () {


        $scope.someText = 'aaa';
        var nodesList = [];
        var fromList = [];

        $http.get('http://localhost:9000/api/vertex').then(function (response) {
            var data = response.data;

            for (var i in data) {
                var node = {
                    id: data[i].id,
                    label: data[i].operation.name,
                    x: data[i].position.xposition,
                    y: data[i].position.yposition,
                    allowedToMoveX: false,
                    allowedToMoveY: false

                };
                var elementFrom = data[i].from;
                for (var j in elementFrom) {
                    var currentFrom = {from: elementFrom[j].from, to: elementFrom[j].to};
                    fromList.push(currentFrom);
                }
                nodesList.push(node);
            }

            var nodes = new vis.DataSet(nodesList);
            var edges = new vis.DataSet(fromList);
            var container = document.querySelector('#mynetwork');
            var data = {
                nodes: nodes,
                edges: edges
            };
            var options = {

                nodes: {
                    shape: 'box',
                    widthConstraint:
                        {minimum: 100, maximum: 100},
                    heightConstraint:
                        {minimum: 60}
                },

                width: '800px',
                height: '800px',
                interaction: {dragNodes: false},

                physics: {enabled: false}

            };
            var network = new vis.Network(container, data, options);


            network.on("click", function (properties) {

                var nodeIds = properties.nodes;
                console.log('node ids:', nodeIds);
                console.log('nodes:', nodes.get(nodeIds));

                var edgeIds = properties.edges;
                console.log('edge ids:', edgeIds);
                console.log('edges:', edges.get(edgeIds));

            });

        });

    }

});

