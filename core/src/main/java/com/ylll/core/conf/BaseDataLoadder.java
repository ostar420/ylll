/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.conf;



/**
 *
 * 项目启动加载类
 */
public class BaseDataLoadder {
    
    /**
     *加载方法
     */
    public void init (){
        new InitBaseProperties().init();
    }
    
     
    
}
