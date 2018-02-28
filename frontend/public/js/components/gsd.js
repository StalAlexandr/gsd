var app = angular.module('myApp');
app.directive('gsd', function() {
  return {
    restrict: 'EA',
    template: '<svg class="gsd" width="500" height="500"></svg>',
    replace: true,
    scope: {
      network: '=',
      nodeClick: '&',
      linkClick: '&'
    },
    link: function(scope, element) {
      var svg = d3.select(element[0])

      scope.$watch('network', function() {
        render();
      });

      function render() {

        svg.selectAll('*').remove();
        if (!scope.network) return;

        var nodes = scope.network.nodes;
        var links = scope.network.links;

        if (!nodes || !links) return;

        var gsd = {};
        function getNodeById(id) {
          return nodes.find(function (node) {
            return node.id == id;
          })
        }
        function getIncidentLinksById(id) {
          return links.filter(function (link) {
            return link.from == id || link.to == id ;
          })
        }
        function getNextLink(id) {
          return links.find(function (link) {
            return link.from == id ;
          })
        }

        gsd.nodes = svg.selectAll('g')
          .data(nodes, function(node) { return node.id });

        gsd.nodes.selectAll('.shape').classed('selected', false)

        var gsdNodes = gsd.nodes
          .enter()
          .append('g')
          .classed('node', true)
          .attr('id', function(node) { return 'n' + node.id })
          .attr('transform', function(node) { return "translate(" + node.x + "," + node.y + ")" })
          .on('click', function(node) {
              console.log('node ' + JSON.stringify(node)  + ' is selected');
              var nextLink = getNextLink(node.id);
              scope.nodeClick({node: nextLink, nextLink: nextLink});
              highlightNode(node);
          });

        gsdNodes.append('circle')
          .classed('shape', true)
          .attr('r', 40)
        gsdNodes.append('text')
          .attr('text-anchor', 'middle')
          // TODO wrap properly
          .text(function (node) { return node.label.substring(0, 10) })

        gsd.links = svg.selectAll('path')
          .data(links, function(link) { return link.from + "-" + link.to});
        gsd.links.classed('selected', false)

        var gsdLinks = gsd.links
          .enter()
          .append('path')
          .classed('link', true)
          .attr('id', function(link) { return 'l' + link.from + '-' + link.to})
          .attr('d', function(link) {
            var from = getNodeById(link.from)
            var to = getNodeById(link.to)
            return "M" + from.x + "," + from.y + "L" + to.x + "," + to.y;
          })
          .on('click', function(link) {
              console.log('link ' + JSON.stringify(link) + ' is selected');
              scope.linkClick({link: link});
              highlightLink(link);
          });

        function highlightNode(node) {
          if (!node || !node.id) return;
          var id = node.id;
          svg.selectAll('.node').classed('selected', false);
          svg.select('#n' + id).classed('selected', true);
          svg.selectAll('.link').classed('selected', false);
          getIncidentLinksById(id).forEach(function (link) {
            svg.select('#l' + link.from + '-' + link.to)
               .classed('selected', true);
          })
        }

        function highlightLink(link) {
          if (!link) return;
          svg.selectAll('.node').classed('selected', false);
          svg.selectAll('.link').classed('selected', false);
          svg.select('#n' + link.from).classed('selected', true)
          svg.select('#n' + link.to).classed('selected', true)
          svg.select('#l' + link.from + '-' + link.to)
             .classed('selected', true);
        }
      }
    }
  }
})
