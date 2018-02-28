var app = angular.module('myApp', []);
app.filter('svgHref', function ($sce) {
    return function (val) {
        return $sce.trustAsResourceUrl(val);
    };
  });
app.controller('myCtrl', function ($scope, $http, $element) {

    $scope.network = {};

    $scope.application={};

    $scope.selectedExtidappli = '';

    $scope.selectedOperation = {};

    $scope.getNodeById = function(id) {
        var nodes = $scope.network.nodes;
        return nodes.find(function (node) {
          return node.id == id;
        })
      }
    $scope.getIncidentLinksById = function(id) {
        var links = $scope.network.links;
        return links.filter(function (link) {
          return link.from == id || link.to == id ;
        })
    }
    $scope.getNextLink = function(node) {
        var links = $scope.network.links;
        var link = links.find(function (link) {
          return link.to == node.id;
        })
        if (link != null) {
          return link;
        } else {
          return links.find(function (link) {
            return link.to == node.id;
          })
        }
    }
    $scope.getPositionBetween = function(link) {
      var p1 = $scope.getNodeById(link.from);
      var p2 = $scope.getNodeById(link.to);
      return {x: (p1.x + p2.x - 5) / 2, y: (p1.y + p2.y + 5) / 2}
    }

    $scope.getApplication = function(){
        $http.get('http://localhost:9000/api/application/'+$scope.selectedExtidappli).then(function (response) {

            if (!response.data.id){
                alert('Заявка не найдена');
                return;
            }

            $scope.application = response.data;
        });
    }

    $scope.isNodeSelected = function(node) {
        return $scope.selectedNode
               && $scope.selectedNode.id == node.id;
    }

    $scope.isLinkSelected = function(link) {
        return $scope.selectedLink
               && $scope.selectedLink.from == link.from
               && $scope.selectedLink.to == link.to;
    }

    $scope.selectStatus = function(status) {
      $scope.selectedNode = status;
      $scope.selectedLink = null;
      var nextLink = $scope.getNextLink(status);
      if (nextLink == null) return;
      $scope.selectedOperation = nextLink.operation;
    }
    $scope.selectOperation = function(operation) {
      $scope.selectedNode = null;
      $scope.selectedLink = operation;
      $scope.selectedOperation = operation.operation;
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
                    // TODO return correct coordinates in response
                    x: d.position.xposition + 50,
                    y: d.position.yposition - 50,
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
            $scope.network = {nodes: nodes, links: links};
        });
    }
});

