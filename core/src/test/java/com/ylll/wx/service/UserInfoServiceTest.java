/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.wx.service;

import com.ylll.wx.service.UserInfoService;
import com.ylll.core.BeseSpringTestSupport;
import com.ylll.wx.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author YL
 */
public class UserInfoServiceTest extends  BeseSpringTestSupport{
    
    @Autowired  
    private UserInfoService userInfoService; 

    /**
     * Test of selectByUserInfo method, of class UserInfoServiceImpl.
     * @throws java.lang.Exception
     */
   // @Test
    public void testSelectByUserInfo() throws Exception {
        System.out.println("selectByUserInfo");
         UserInfo entity = initTestUserInfo(1).get(0);
        List<UserInfo> list =  userInfoService.selectByUserInfo(entity, 1, 10);
        
       // Assert.assertEquals(0,list.size());
        
    }

    /**
     * Test of save method, of class UserInfoServiceImpl.
     * @throws java.lang.Exception
     */
    //@Test
    public void testSave() throws Exception {
        System.out.println("save");
        UserInfo entity = initTestUserInfo(1).get(0);
        int r   = userInfoService.save(entity);
       // Assert.assertEquals(1,r);
    }

    /**
     * Test of delete method, of class UserInfoServiceImpl.
     * @throws java.lang.Exception
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int r   = userInfoService.delete("1");
       // Assert.assertEquals(0,r);
    }

    /**
     * Test of updateAll method, of class UserInfoServiceImpl.
     * @throws java.lang.Exception
     */
   // @Test
    public void testUpdateAll() throws Exception {
        System.out.println("updateAll");
         UserInfo entity = initTestUserInfo(1).get(0);
        int r   = userInfoService.updateAll(entity);
        //Assert.assertEquals(0,r);
    }

    /**
     * Test of batchInsertUser method, of class UserInfoServiceImpl.
     * @throws java.lang.Exception
     */
    //@Test
    public void testBatchInsertUser() throws Exception {
        System.out.println("batchInsertUser");
         List<UserInfo> list = initTestUserInfo(10);
         int r   = userInfoService.batchInsertUser(list);
        //Assert.assertEquals(10,r);
    }

    /**
     * Test of batchDeleteUser method, of class UserInfoServiceImpl.
     * @throws java.lang.Exception
     */
    //@Test
    public void testBatchDeleteUser() throws Exception {
        System.out.println("batchDeleteUser");
        List<String> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
         int r   = userInfoService.batchDeleteUser(list);
        //Assert.assertEquals(0,r);
    }
    
    
    private List<UserInfo> initTestUserInfo(int count){
         List<UserInfo> list = new ArrayList<>();
         UserInfo userInfo = null;
        for (int i = 0; i < count; i++) {
            userInfo= new UserInfo();
            userInfo.setId(i+"key");
            userInfo.setName("测试"+i);
            userInfo.setPhone("+86 "+i);
            userInfo.setEmail("+86 "+i);
            list.add(userInfo);
            
        }
        return list;
        
    }
    
}
