'use strict'
describe "BranchesCtrl", ->
  $httpBackend = {}
  scope = {}
  beforeEach( ->
    module 'gitviewApp'
    inject (_$httpBackend_,$rootScope,$controller) ->
     $httpBackend = _$httpBackend_
     $httpBackend.expectGET('api/branches.json').
         respond { branches: ['master','dev','release'], head: 'master'}
     scope = $rootScope.$new()
  )

  it "should show which branch is checked out", inject ($controller) ->
    $controller('BranchesCtrl', { $scope: scope })
    $httpBackend.flush()
    expect(scope.head).toBe 'master'

  it "should list all branches", inject ($controller) ->
    $controller('BranchesCtrl', { $scope: scope })
    $httpBackend.flush()

    expect(scope.branches).toEqual ['master','dev','release']
    #expect(scope.branches.length).toBe 3
    #expect(scope.branches).toContain 'master'
    #expect(scope.branches).toContain 'dev'
    #expect(scope.branches).toContain 'release'