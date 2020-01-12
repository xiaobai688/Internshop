app.service('brandService',function($http){
    //查询全部
    this.findAll=function(){
        return $http.get('/brand/findAll');
    }
    //分页查询全部
    this.findPage=function (page,rows) {
        return $http.get('/brand/findPage?page='+page+'&rows='+rows);
    }
    //查询单个
    this.findById=function (id) {
        return  $http.get('/brand/findById?id='+id);
    }
    //增加数据
    this.addBrand=function (brand) {
        return $http.post('/brand/addBrand',brand);
    }
    //修改数据
    this.updateBrand=function (brand) {
        return $http.post('/brand/updateBrand',brand);
    }
    //删除数据
    this.deleteBrand=function (selectIds) {
        return $http.get('/brand/deleteBrand?ids='+selectIds);
    }
    //条件查询
    this.search=function (page,rows,searchEntity) {
        return $http.post('/brand/search?page='+page+"&rows="+rows,searchEntity);
    }
    //下拉列表
    this.selectOptionList=function(){
        return $http.get('/brand/selectOptionList');
    }

});