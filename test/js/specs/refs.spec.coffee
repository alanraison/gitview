'use strict'
describe "BranchesCtrl", ->
  $httpBackend = {}
  scope = {}
  expectedRefs = [{
    name:'master'
    hash:'aaaaa'
    comment:'one'
    },{
    name:'dev'
    hash:'bbbbb'
    comment:"two"
    },{
    name:'release'
    hash:'ccccc'
    comment:'three'
    }
  ]

  beforeEach( ->
    module 'gitviewApp'
    inject (_$httpBackend_,$rootScope,$controller) ->
      $httpBackend = _$httpBackend_
      $httpBackend.expectGET('refs').respond expectedRefs

      scope = $rootScope.$new()
  )

  it "should list all refs", inject ($controller,$location) ->
    $controller('RefsCtrl', { $scope: scope })
    $httpBackend.flush()

    expect(scope.refs).toEqual expectedRefs