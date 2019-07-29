package com.momo.solr.controller;

import com.momo.solr.domain.QInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {
    @Autowired
    private SolrClient client;
    @RequestMapping("/hello")
    public Object hello() throws IOException, SolrServerException {
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("item_title","Apple iPhone X (A1865) 64GB 深空灰色 移动联通电信4G手机");
        doc.setField("item_sell_point","【抢券立减200元！】5.8英寸视网膜全面屏，无线充电，面容ID，1200万后置双摄。");
        doc.setField("item_price",6299.00);
        doc.setField("item_category_name","手机");
        doc.setField("item_desc","单卡单待网络制式：4G LTE全网通机身内存：64GB4G LTE网络特性：移动4G");
        client.add("collection1",doc);
        client.commit("collection1");
        return "ok";
    }

    /**
     * 增加或更新
     * @param txt
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @RequestMapping("/addBean")
    public Object addBean(String txt) throws IOException, SolrServerException {
        QInfo qInfo=new QInfo();
        qInfo.setId("3b5dcbda-2739-4dab-9374-3ea9360362a9");
        qInfo.setItemTitle(txt);
        qInfo.setItemSellPoint("5.8英寸视网膜全面屏");
        qInfo.setItemCategoryName("手机");
        qInfo.setItemPrice(5299);
        client.addBean(qInfo);
        client.commit();
        return "Success addBean";
    }

    /**
     * 删除操作
     * @param id
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @RequestMapping("/deleteById")
    public Object deleteById(String id) throws IOException, SolrServerException {
        UpdateResponse updateResponse = client.deleteById(id);
        client.commit();
        return "执行用时："+updateResponse.getElapsedTime();
    }
}