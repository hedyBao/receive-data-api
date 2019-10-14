package com.baobao.bo;


public class BasicResponseModel {
    private DiancanOrderPreCheckRemoteResponse content;
    private int code;
    private String msg;

    private static final String SUCCESS_CODE = "200";

    public Boolean isSuccess(){
        return SUCCESS_CODE.equals(code) && msg.equals("成功") && content.isAvailable(1,1);

    }

    public BasicResponseModel(){

    }

    public BasicResponseModel(DiancanOrderPreCheckRemoteResponse content,int Code,String msg){
        this.content = content;
        this.code = code;
        this.msg = msg;

    }

    public DiancanOrderPreCheckRemoteResponse getContent() {
        return content;
    }

    public void setContent(DiancanOrderPreCheckRemoteResponse content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
