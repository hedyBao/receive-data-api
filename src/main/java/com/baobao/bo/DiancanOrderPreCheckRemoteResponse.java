package com.baobao.bo;


public class DiancanOrderPreCheckRemoteResponse {
    private int venderStatus;
    private int shopStatus;

    private static final String AVAILABLE_CODE = "1";

    public Boolean isAvailable(int venderStatus, int shopStatus){
        return AVAILABLE_CODE.equals(venderStatus)&&AVAILABLE_CODE.equals(shopStatus);
    }



    public DiancanOrderPreCheckRemoteResponse(){

    }

    public int getVenderStatus() {
        return venderStatus;
    }

    public void setVenderStatus(int venderStatus) {
        this.venderStatus = venderStatus;
    }

    public int getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(int shopStatus) {
        this.shopStatus = shopStatus;
    }

    public DiancanOrderPreCheckRemoteResponse(int venderStatus, int shopStatus){
        this.venderStatus = venderStatus;
        this.shopStatus=shopStatus;

    }
}

