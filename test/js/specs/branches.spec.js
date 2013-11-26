describe("BranchesCtrl", function() {
  beforeEach(module('branches'));

  it("should show which branch is checked out", inject(function($controller) {
    var scope = {};
    var ctrl = $controller('BranchesCtrl', { $scope: scope });
    expect(scope.branches.head).toBe('master');
  }));
});