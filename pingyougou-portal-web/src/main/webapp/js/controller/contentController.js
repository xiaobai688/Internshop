app.controller('contentController',function($scope,contentService){
	
	$scope.contentList=[];//广告列表
	
	$scope.findByCategoryId=function(categoryId){
		contentService.findByCategoryId(categoryId).success(
			function(response){
				$scope.contentList[categoryId]=response;
			}
		);		
	}

	//跳转到搜索页面
	$scope.search=function () {
		location.href="http://localhost:9401/search.html#?keywords="+$scope.keywords;
	}

	//跳转到购物车页面
	$scope.cart=function () {
		location.href="http://localhost:9701/cart.html#?keywords="+$scope.keywords;
	}
});