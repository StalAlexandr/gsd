var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http, $element) {

    $scope.doSome = function (text) {
        $scope.currentOperation = text;
        $scope.$apply();
    };

    $scope.init = function () {
        $scope.currentOperation = '';
        var nodesList = [];
        var fromList = [];

        $http.get('http://localhost:9000/api/vertex').then(function (response) {
            var data = response.data;

            for (var i in data) {
                var node = {
                    id: data[i].id,
                    label: data[i].status.name,
                    x: data[i].position.xposition,
                    y: data[i].position.yposition,
                    allowedToMoveX: false,
                    allowedToMoveY: false

                };
                var elementFrom = data[i].from;
                for (var j in elementFrom) {
                    var currentFrom = {
                        arrows: 'to',
                        id: elementFrom[j].id,
                        from: elementFrom[j].from,
                        to: elementFrom[j].to,
                        label: elementFrom[j].code,
                        name: elementFrom[j].name
                    };
                    fromList.push(currentFrom);
                }
                nodesList.push(node);
            }

            var nodes = new vis.DataSet(nodesList);
            var edges = new vis.DataSet(fromList);
            var container = document.querySelector('#stdnetwork');
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

                //    width: '800px',
                //    height: '800px',
                interaction: {dragNodes: false, zoomView: false, dragView: false},  //, dragView: false

                physics: {enabled: false},

            };

            var network = new vis.Network(container, data, options);
            network.on("click", function (properties) {

                var nodeIds = properties.nodes;

                var edgeIds = properties.edges;
                if (edgeIds[0]) {
                    $scope.doSome(edges.get(edgeIds[0]).name);
                }
            });

        });

    }

});

