package com.terry.springbootmall.dao;

import com.terry.springbootmall.dto.OrderQueryParams;
import com.terry.springbootmall.model.Order;
import com.terry.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);  //擴充

    Integer createOrder(Integer userId, Integer totalAmount);
    void  createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
