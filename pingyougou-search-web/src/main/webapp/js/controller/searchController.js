app.controller('searchController',function($scope,$location,searchService){
	//添加搜索条件
	$scope.searchMap={'keywords':'','category':'','brand':'','spec':{},'price':'','pageNo':1,'pageSize':20,'sort':'','sortFiled':''};

	//搜索
	$scope.search=function(){
	    $scope.searchMap.pageNo=parseInt($scope.searchMap.pageNo);//转换为数字
		searchService.search($scope.searchMap).success(
			function(response){
				$scope.resultMap=response;
               // $scope.searchMap.pageNo=1;
				buildPageLabel();//构件分页栏
			}
		);		
	}

	//分页栏
	buildPageLabel=function(){
	    $scope.pageLabel=[];
	    var firstPage=1;//起始页码
	    var lastPage=$scope.resultMap.totalPages;//截止页码

        $scope.firstDot=true;
        $scope.lastDot=true;
	    //只显示5个页码
        if($scope.resultMap.totalPages>5){//如果页码数量大于5
            if($scope.searchMap.pageNo<=3){//如果当前页码小于等于3
                lastPage=5;
                $scope.firstDot=false;
            }else if($scope.searchMap.pageNo>$scope.resultMap.totalPages-2){
                firstPage=$scope.resultMap.totalPages-4;
                $scope.lastDot=false;
            }else{
                firstPage=$scope.searchMap.pageNo-2;
                lastPage=$scope.searchMap.pageNo+2;
            }
        }else{
            $scope.firstDot=false;
            $scope.lastDot=false;
        }
	    for(var i=firstPage;i<=lastPage;i++){
	        $scope.pageLabel.push(i);
        }
    }

	//添加搜索方法
	$scope.addSearchMap=function (key,value) {
		if(key=='category'||key=='brand'||key=='price'){//如果用户点击的是分类或品牌
			$scope.searchMap[key]=value;
		}else{//用户点击的是规格
			$scope.searchMap.spec[key]=value;
		}
		$scope.search();
	}

	//移除搜索条件方法
	$scope.removeSearchMap=function (key) {
		if(key=='category'||key=='brand'||key=='price'){//如果用户点击的是分类或品牌
			$scope.searchMap[key]="";
		}else{//用户点击的是规格
			delete $scope.searchMap.spec[key];
		}
		$scope.search();
	}

    //根据页码查询
    $scope.queryByPage=function(pageNo){
        //页码验证
        if(pageNo<1 || pageNo>$scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo=pageNo;
        $scope.search();
    }

    //判断当前页是否为第一页
    $scope.isToPage=function () {
        if($scope.searchMap.pageNo==1){
            return true;
        }else {
            return false;
        }
    }

    //判断当前页是否为最后一页
    $scope.isEndPage=function () {
        if($scope.searchMap.pageNo==$scope.resultMap.totalPages){
            return true;
        }else {
            return false;
        }
    }

    //排序查询
    $scope.sortSearch=function (sort,sortFiled) {
        $scope.searchMap.sort=sort;
        $scope.searchMap.sortFiled=sortFiled;
        $scope.search();
    }

    //判断关键字是不是品牌
    $scope.keywordsIsBrand=function(){
        for(var i=0;i<$scope.resultMap.brandList.length;i++){
            if($scope.searchMap.keywords.indexOf($scope.resultMap.brandList[i].text)>=0){//如果包含
                return true;
            }
        }
        return false;
    }

    //加载查询字符串
    $scope.loadkeywords=function(){
        $scope.searchMap.keywords=  $location.search()['keywords'];
        $scope.search();
    }


});