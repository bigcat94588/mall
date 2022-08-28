package com.terry.springbootmall.dao;
import com.terry.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
