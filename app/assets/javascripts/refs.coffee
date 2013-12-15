'use strict'
gitviewApp = angular.module('gitviewApp',[])

gitviewApp.controller('RefsCtrl', ['$scope','$http',($scope,$http) ->
    $http.get('refs').success (data) ->
        $scope.refs = data
])