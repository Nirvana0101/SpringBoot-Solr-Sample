package com.momo.solr.domain;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class QInfo implements Serializable {
    @Field(value="id")
    private String id;
    @Field(value="item_title")
    private String itemTitle;

    @Field(value="item_sell_point")
    private String itemSellPoint;

    @Field(value="item_price")
    private Integer itemPrice;

    @Field(value="item_category_name")
    private String itemCategoryName;

    @Field(value="item_desc")
    private String itemDesc;

    public QInfo() {
    }

    public QInfo(String itemTitle, String itemSellPoint, Integer itemPrice, String itemCategoryName, String itemDesc) {
        this.itemTitle = itemTitle;
        this.itemSellPoint = itemSellPoint;
        this.itemPrice = itemPrice;
        this.itemCategoryName = itemCategoryName;
        this.itemDesc = itemDesc;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemSellPoint() {
        return itemSellPoint;
    }

    public void setItemSellPoint(String itemSellPoint) {
        this.itemSellPoint = itemSellPoint;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
