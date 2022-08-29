package com.terry.springbootmall.constant;

public class MyTest {
    public static void main(String[] args) {
        ProductCategory category = ProductCategory.FOOD;
        String s = category.name(); //將FOOD轉換成字串
        System.out.println(s);

        String s2 = "CAR";
        ProductCategory category2 = ProductCategory.valueOf(s2);

    }
}
