'use strict'
gitviewApp = angular.module('gitviewApp',[])

gitviewApp.controller('RefsCtrl', ['$scope','$http',($scope,$http) ->
    $http.get('refs').success (data) ->
        $scope.refs = data
])

gitviewApp.controller('ReposCtrl', ['$scope','$http',($scope,$http) ->
    $http.get('/-/repos').success (data) ->
        $scope.repos = data
])