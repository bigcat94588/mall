package com.terry.springbootmall.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderRequest {

  @NotEmpty   //用來加在list或map的集合變數
  private List<BuyItem> buyItemList;

  public List<BuyItem> getBuyItemList() {
        return buyItemList;
  }

  public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
  }
}
