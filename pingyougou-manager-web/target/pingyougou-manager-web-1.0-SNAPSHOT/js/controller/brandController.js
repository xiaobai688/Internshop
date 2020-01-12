app.controller('brandController',function ($scope,$controller,brandService) {
    //查询品牌列表
    $scope.findAll=function () {
        brandService.findAll().success(
            function (response) {
                $scope.list=response;
            }
        );
    }
    //分页
    $scope.findPage=function(page,rows){
        brandService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    //继承公用方法
    $controller('baseController',{$scope:$scope});
    //将增加和保存合并
    $scope.save=function(){
        var object=null;//方法名称
        if($scope.brand.id!=null){//如果有ID
            object=brandService.updateBrand($scope.brand);
        }else{
            object=brandService.addBrand($scope.brand);
        }
        object.success(
            function (response) {
                if(response.success){
                    $scope.reloadList()//局部刷新
                }else{
                    alert(response.message)
                }
            }
        );
    }
    //增加

    //查询单个品牌
    $scope.findById=function (id) {
        brandService.findById(id).success(
            function (response) {
                $scope.brand=response;
            }
        );
    }

    //批量删除
    $scope.deleteBrand=function(){
        //获取选中的复选框
        brandService.deleteBrand($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新列表
                }else{
                    alert(response.message)
                }
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //条件查询
    $scope.search=function(page,rows){
        brandService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }


});