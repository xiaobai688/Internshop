package com.pinyougou.cart.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pay.service.WeiXiPayService;
import com.pinyougou.pojo.TbPayLog;
import com.pinyougou.service.OrderService;
import com.sun.org.apache.regexp.internal.RE;
import entry.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.IdWorker;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付控制层
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/pay")
public class WeiXiPayController {

    @Reference
    private WeiXiPayService weixiPayService;

    @Reference
    private OrderService orderService;

    /**
     * 生成二维码
     * @return
     */
    @RequestMapping("/createNative")
    public Map createNative() {
        //获取当前用户
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        //到redis查询支付日志
        TbPayLog payLog = orderService.searchPayLogFromRedis(userId);
        //判断支付日志存在
        if (payLog != null) {
            return weixiPayService.createNative(payLog.getOutTradeNo(), payLog.getTotalFee() + "");
        } else {
            return new HashMap();

        }
    }

    /**
     * 判断支付状态
     * @return
     */
    @RequestMapping("/getPayStatus")
    public Result getPayStatus(String out_trade_no){

        Result result=null;
        int x=0;
        while(true){
            //调用查询接口
            Map<String,String> map = weixiPayService.getPayStatus(out_trade_no);
            if(map==null){//出错
                result=new  Result(false, "支付出错");
                break;
            }
            if(map.get("trade_state").equals("SUCCESS")){//如果成功
                result=new  Result(true, "支付成功");
                //修改订单状态
                orderService.updateOrderStatus(out_trade_no, map.get("transaction_id"));

                break;
            }
            try {
                Thread.sleep(3000);//间隔三秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //为了不让循环无休止地运行，我们定义一个循环变量，如果这个变量超过了这个值则退出循环，设置时间为5分钟
            x++;
            if(x>=40){
                result=new  Result(false, "二维码超时");
                break;
            }

        }
        return result;
    }

}
