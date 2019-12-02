package com.zhunongyun.toalibaba.designpatterns.proxy.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            Date today = new Date();
            order.setCreateTime(today.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");

            order.setCreateTime(date.getTime());

            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}