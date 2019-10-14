package com.baobao.yddHttpUtils;

//向ydd提供的http接口发起post请求，查询映射关系

import com.alibaba.fastjson.JSON;
import com.baobao.YddHashMapRepository.YddOrdersMap;
import com.baobao.yddPojo.DiancanOrderPushRemoteRequest;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class YddHttpClientUtils {
    @Autowired
    private YddOrdersMap yddOrdersMap;


    private static final String HTTP_CONTENT_CHARSET="UTF-8";
    private static final Integer MAX_TIME_OUT = 10000;
    private static final Integer MAX_IDLE_TIME_OUT = 20000;
    private static final Long MAX_MANAGER_TIME = 1000L;
    private static final Integer MAX_CONN = 100;
    private static final String URL = "https://open-api.dianping.com/vendor/shopMapping/query";
    private static HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();

    static {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.closeIdleConnections(MAX_IDLE_TIME_OUT);
        connectionManager.getParams().setParameter(HttpConnectionManagerParams.MAX_TOTAL_CONNECTIONS, MAX_CONN);
        httpClient.setHttpConnectionManager(connectionManager);
        httpClient.getParams().setSoTimeout(MAX_TIME_OUT);
        httpClient.getParams().setConnectionManagerTimeout(MAX_MANAGER_TIME);
    }



    public BasicResponseModel doPostShopMappingQuery(String url, Map<String,String> data, DiancanOrderPushRemoteRequest orderParams){
        HashMap<String , String > map = new HashMap<>();
        PostMethod p = new PostMethod(URL);
        if (data != null) {
            map.put("ydd_param_json", JSON.toJSONString(data));
        }

        map.put("dpShopIdList", orderParams.getDpShopId());
        map.put("vendorShopIdList",orderParams.getVendorShopId());
        map.put("businessType","10");

        p.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, HTTP_CONTENT_CHARSET);
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getValue()!=null){
                p.addParameter(entry.getKey(),entry.getValue());
            }
        }
        p.addRequestHeader("Connection","close");
        try {
            httpClient.executeMethod(p);
            String responseBody= p.getResponseBodyAsString();
            BasicResponseModel responseModel = JSON.parseObject(responseBody,BasicResponseModel.class);
            if(responseModel.getCode()== HttpStatus.SC_OK){
                VendorMappingApi responseMapping = responseModel.getContent();
                yddOrdersMap.saveVenderMapping(responseMapping.getVendorShopId(),responseMapping.getDpShopId());
                return responseModel;
            }

        }catch (IOException e){
            e.getMessage();

        }finally {
            p.releaseConnection();
        }
        throw new RuntimeException("异常");
    }






}
