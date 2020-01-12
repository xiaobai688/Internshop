package com.pinyougou.pay.service;

import java.util.Map;

/**
 * 微信支付接口
 */
public interface WeiXiPayService {

    /**
     * @param out_trade_no  商户订单编号
     * @param total_fee     总金额
     * @return
     */
    public Map createNative(String out_trade_no, String total_fee);

    /**
     * @param out_trade_no  商户订单编号
     * @return
     */
    public Map getPayStatus(String out_trade_no);

    /**
     * 查询支付订单状态
     * @param out_trade_no
     * @return
     */
    public Map queryPayStatus(String out_trade_no);


    /**
     * 关闭订单
     * @param out_trade_no
     * @return
     */
    public Map closePay(String out_trade_no);

}
