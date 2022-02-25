
angular.module('whiteSourceApp', [])
    .controller('apiCtrl',[ '$scope',
    function($scope) {

        $scope.init = function () {
            $scope.loginInput = {
                userName: undefined,
                password: undefined
            };
        }

      }
    ]);