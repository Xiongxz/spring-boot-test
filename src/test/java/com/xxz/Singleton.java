package com.xxz;

/**
 * @Auther: Administrator
 * @Date: 2018/6/28 0028 11:55
 * @Description:
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return  singleton;
    }
}
