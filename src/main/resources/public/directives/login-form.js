
    /*** Login Form Directive */

    angular.module('whiteSourceApp')
        .directive('loginForm', function () {
        return {
            scope: {
                inputData: '='
            },
            templateUrl: "html/login-form.html",
            controller: function ($scope, $http, $window) {
                const CONST = {
                    LOGIN_HIBERNATE_API:'http://localhost:8080/white_source_full_stack/',
                    SUCCESS_MSG: "Login success for employee:",
                    FAILED_MSG: "Login failed for employee:",
                    GET: "GET",
                    SEPARATOR: "/",
                    SUCCESS: "success",
                    FAILED: "failed",
                    RESPONSE_IS_EMPTY_MSG: "Response is null"
                };

                $scope.loginWhiteSourceWithHibernate = function () {
                    loginApiCall();
                }

                function loginApiCall() {
                    const link = CONST.LOGIN_HIBERNATE_API + $scope.loginInput.userName +
                        CONST.SEPARATOR + $scope.loginInput.password;
                    $http({
                        url: link,
                        method: CONST.GET
                    }).then(
                        function successCallback(response) {
                            successCallbackHelper(response);
                        },
                        function errorCallback() {
                            $window.alert(CONST.FAILED_MSG + $scope.loginInput.userName);
                        }
                    );
                };

                function successCallbackHelper(response) {
                    if(response && response.data) {
                        if(response.data.result == CONST.SUCCESS) {
                            $window.alert(CONST.SUCCESS_MSG + $scope.loginInput.userName);
                        } else if(response.data.result == CONST.FAILED) {
                            $window.alert(CONST.FAILED_MSG + $scope.loginInput.userName);
                        }
                    } else {
                        $window.alert(CONST.FAILED_MSG + $scope.loginInput.userName);
                    }
                }
            }
        }
    });