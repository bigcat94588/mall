package com.terry.springbootmall.service;

import com.terry.springbootmall.dto.CreateOrderRequest;
import com.terry.springbootmall.dto.OrderQueryParams;
import com.terry.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);
    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
