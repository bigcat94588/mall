package com.terry.springbootmall.service;

import com.terry.springbootmall.dto.CreateOrderRequest;
import com.terry.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
