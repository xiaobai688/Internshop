//用于登录的服务层js
app.service('loginService',function($http){
    this.loginName=function () {
        return $http.get('/login/name');
    }
});