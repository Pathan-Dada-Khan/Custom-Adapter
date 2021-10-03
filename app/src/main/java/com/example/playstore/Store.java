package com.example.playstore;

public class Store {
    String title1,des1,app;
    int res1;
    public Store(String title,String des,int res,String appName){
        title1=title;
        des1=des;
        res1=res;
        app=appName;
    }
    public String getTitle(){ return title1;}
    public String getDes(){ return des1;}
    public int getImg(){ return res1;}
    public String getApp(){return app;}
}
