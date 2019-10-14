package com.baobao.YddHashMapRepository;

import com.baobao.yddPojo.DiancanOrderPushRemoteRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class YddOrdersMap {

    HashMap<String, DiancanOrderPushRemoteRequest> yddOrderMap = new HashMap<>();

    private HashMap<String,Object> yddOrderParamsMap = new HashMap<>();

    private HashMap<String,Object> venderMapping = new HashMap<>();

    public void saveYddOrderParams(String str, Object obj){

        yddOrderParamsMap.put(str,obj);
    }

    public Object getYddOrderParam(String str){
        return yddOrderParamsMap.get(str);
    }

    public void saveYddOrder(String str, DiancanOrderPushRemoteRequest r){
        yddOrderMap.put(str,r);

    }

    public void saveVenderMapping(String str, Object obj){
        venderMapping.put(str,obj);
    }

    public Boolean isMapping(String str){
        if(venderMapping.get(str)!= null){
            return true;
        }
        return false;
    }








}
