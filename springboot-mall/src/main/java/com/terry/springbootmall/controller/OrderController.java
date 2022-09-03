package com.terry.springbootmall.controller;

import com.terry.springbootmall.dto.CreateOrderRequest;
import com.terry.springbootmall.dto.OrderQueryParams;
import com.terry.springbootmall.model.Order;
import com.terry.springbootmall.service.OrderService;
import com.terry.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")  //查詢該帳號歷史訂單
    public ResponseEntity<Page<Order>> getOrders(

            @PathVariable Integer userId,

            //分頁 Pagination
            @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0")  @Min(0) Integer offset

    ){
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setLimit(limit);
        orderQueryParams.setOffset(offset);

        //取得order list
        List<Order> orderList = orderService.getOrders(orderQueryParams);
        //取得order總筆數
        Integer count = orderService.countOrder(orderQueryParams);
        //分頁
        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);  //RESTful設計理念，不去判斷是否有商品存在
    }


    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){

        Integer orderId = orderService.createOrder(userId,createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return  ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
