'use strict'
gitviewApp = angular.module('gitviewApp', [])

gitviewApp.controller('BranchesCtrl', ['$scope','$http',($scope,$http) ->
    $http.get('api/branches.json').success (data) ->
        $scope.branches = data.branches
        $scope.head = data.head
])