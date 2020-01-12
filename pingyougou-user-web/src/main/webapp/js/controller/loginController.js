//控制层
app.controller('loginController' ,function($scope,$controller,loginService) {
    //获取登录名
    $scope.getLoginName = function () {
        loginService.getLoginName().success(
            function (response) {
                $scope.loginName = response.loginName;
            }
        );
    }
});