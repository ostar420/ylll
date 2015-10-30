package com.ylll.wx.controller;

import com.github.pagehelper.PageInfo;
import com.ylll.core.annotation.ParamVali;
import com.ylll.core.poj.MessagePO;
import com.ylll.wx.model.UserInfo;
import com.ylll.wx.service.UserInfoService;
import com.ylll.core.util.BaseControllerSupport;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author YL
 */
@Controller
@RequestMapping(value = "/user")
public class UserInfoController  extends  BaseControllerSupport{
    
    @Autowired
    private UserInfoService userInfoService;
    
    
    
    @RequestMapping(value = "findPage")
    @ResponseBody
    public PageInfo<UserInfo> findPage() {
        
        List<UserInfo> list = null;
        try {
            list = userInfoService.selectByUserInfo(convertToBean(UserInfo.class), getPage(), getRows());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            list = new ArrayList<>();
            logger.error("/user/findPage error :{}",ex.getMessage());
        }
        return new PageInfo<UserInfo>(list);
    }
    
    
    @RequestMapping(value = "add")
    @ResponseBody
    @ParamVali(bean=UserInfo.class)//校验标识
    public MessagePO add(){
        MessagePO po = new MessagePO();
        try {
            int r = userInfoService.save(convertToBean(UserInfo.class));
            if(r>0){
                po.setFlag(MessagePO.SUCCESS);
            }
        }
        catch (Exception e) {
            po.setContent(e.getMessage());
        }
        return po;
    }
    
    @RequestMapping(value = "update")
    @ResponseBody
    @ParamVali(bean=UserInfo.class)//校验标识
    public MessagePO update(){
        MessagePO po = new MessagePO();
        try {
            int r = userInfoService.updateAll(convertToBean(UserInfo.class));
            if(r>0){
                po.setFlag(MessagePO.SUCCESS);
            }
        }
        catch (Exception e) {
            po.setContent(e.getMessage());
        }
        return po;
    }
    
    @RequestMapping(value = "delete")
    @ResponseBody
    @ParamVali(bean=UserInfo.class,params = {"id"})//校验标识 params 有值时候 只校验params参数,否则对象全部字段校验
    public MessagePO delete(){
        MessagePO po = new MessagePO();
        try {
            int r = userInfoService.delete(convertToBean(UserInfo.class));
            if(r>0){
                po.setFlag(MessagePO.SUCCESS);
            }
        }
        catch (Exception e) {
            po.setContent(e.getMessage());
        }
        return po;
    }
    
    @RequestMapping(value = "findSingle")
    @ResponseBody
    @ParamVali(bean=UserInfo.class,params = {"id"})//校验标识 params 有值时候 只校验params参数,否则对象全部字段校验
    public UserInfo findSingle(){
        try {
        UserInfo info = userInfoService.selectByKey(convertToBean(UserInfo.class));
        if(info!=null)
            return info;
        }
        catch (Exception e) {
        }
        return new UserInfo();
    }
    
}
