package com.terry.springbootmall.dao;
import com.terry.springbootmall.constant.ProductCategory;
import com.terry.springbootmall.dto.ProductRequest;
import com.terry.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
