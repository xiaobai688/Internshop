//服务层
app.service('loginService',function($http){
    //读取登录名
    this.getLoginName=function(){
        return $http.get('/login/getLoginName');
    }
});