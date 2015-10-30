package com.ylll.core.poj;

import net.sf.json.JSONObject;

/**
 *
 * 用于返回结果的实体类
 */
public class MessagePO {
    
    /**
     *
     */
    public static final String SUCCESS = "success";

    /**
     *
     */
    public static final String ERROR = "error";

    /**
     *
     */
    public static final String WARNING = "warning";
    
    
    private String flag;//结果标识
    private String content;//内容
    private Object obj;//自定义对象
    
    /**
     * 默认构造器 默认赋值 结果标识this.flag = ERROR;
     */
    public MessagePO(){
        this.flag = ERROR;
    }
    /**
     * 默认赋值 结果标识this.flag = ERROR;
     * @param content  内容
     */
    public MessagePO(String content){
         this.flag = ERROR;
         this.content = content;
    }
    
    /**
     * @param flag 结果标识(success,error,warning)
     * @param content  内容
     */
    public MessagePO(String flag,String content){
         this.flag = flag;
         this.content = content;
    }
    /**
     * 
     * @param flag 结果标识(success,error,warning)
     * @param content 内容
     * @param obj  自定义对象
     */
    public MessagePO(String flag,String content,Object obj){
         this.flag = flag;
         this.content = content;
         this.obj = obj;
    }
    
    /**
     * @return 结果标识(success,error,warning)
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag 结果标识(success,error,warning)
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @return  内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content  内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return 自定义对象
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj 自定义对象
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }
    
    @Override
    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
    
}
