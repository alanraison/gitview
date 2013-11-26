gitviewApp = angular.module('gitviewApp', []);

gitviewApp.controller('BranchesCtrl', ['$scope','$http',($scope,$http) ->
    $scope.branches = [ 'master', 'dev', 'release' ]
    $scope.head = 'master'
])