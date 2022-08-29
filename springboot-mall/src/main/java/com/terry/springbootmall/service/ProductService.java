package com.terry.springbootmall.service;

import com.terry.springbootmall.dto.ProductRequest;
import com.terry.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId,ProductRequest productRequest);
}
