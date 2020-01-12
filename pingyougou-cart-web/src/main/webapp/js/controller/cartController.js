//购物车控制层
app.controller('cartController',function($scope,cartService,addressService){
	//查询购物车列表
	$scope.findCartList=function(){
		cartService.findCartList().success(
			function(response){
				$scope.cartList=response;
				$scope.totalValue= cartService.sum($scope.cartList);
			}
		);
	}
	
	//数量加减
	$scope.addGoodsToCartList=function(itemId,num){
		cartService.addGoodsToCartList(itemId,num).success(
			function(response){
				if(response.success){//如果成功
					$scope.findCartList();//刷新列表
				}else{
					alert(response.message);
				}				
			}		
		);		
	}
	
	//查找收货地址
	$scope.findAddressList=function () {
		cartService.findAddressList().success(
			function (response) {
				$scope.addressList=response;
				//设置默认地址
				for(var i=0;i< $scope.addressList.length;i++){
					if($scope.addressList[i].isDefault=='1'){
						$scope.address=$scope.addressList[i];
						break;
					}
				}

			}
		)
	}

	//选择地址
	$scope.selectAddress=function(address){
		$scope.address=address;
	}


	//是否被选择
	$scope.isSelectedAddress=function(address){
		if(address==$scope.address){
			return true;
		}else{
			return false;
		}
	}

	$scope.order={paymentType:'1'};
	//选择支付方式
	$scope.selectPayType=function(type){
		$scope.order.paymentType= type;
	}


	//查询实体
	$scope.findOne=function(id){
		addressService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);
	}

	//保存
	$scope.save=function(){
		var serviceObject;//服务层对象
		if($scope.entity.id!=null){//如果有ID
			serviceObject=addressService.update( $scope.entity ); //修改
		}else{
			serviceObject=addressService.add( $scope.entity  );//增加
		}
		serviceObject.success(
			function(response){
				if(response.success){

					//重新查询
					$scope.findAddressList();
				}else{
					alert(response.message);
				}
			}
		);
	}


	//批量删除
	$scope.dele=function(id){
		//获取选中的复选框
		addressService.dele( id ).success(
			function(response){
				if(response.success){
					$scope.findAddressList();
				}else{
					response.message;
				}
			}
		);
	}

	//保存订单
	$scope.submitOrder=function(){
		$scope.order.receiverAreaName=$scope.address.address;//地址
		$scope.order.receiverMobile=$scope.address.mobile;//手机
		$scope.order.receiver=$scope.address.contact;//联系人
		cartService.submitOrder( $scope.order ).success(
			function(response){
				if(response.success){
					//页面跳转
					if($scope.order.paymentType=='1'){//如果是微信支付，跳转到支付页面
						location.href="pay.html";
					}else{//如果货到付款，跳转到提示页面
						location.href="paysuccess.html";
					}
				}else{
					alert(response.message);	//也可以跳转到提示页面
				}
			}
		);
	}

});