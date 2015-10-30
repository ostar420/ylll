/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 *
 * @author YL
 */
public class CommonTest {

    public void testConvertSourData() {
        File file = new File("E:/dic_general.txt");
        FileWriter fw = null;
        BufferedWriter writer = null;
        //0 25 34  36  40 54  56 62 66 73 76 82 87
        int ages [] = {0,25, 34 ,36  ,40 ,54  ,56 ,62 ,66 ,73, 76 ,82, 87};
        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
           for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j <= 5; j++) {
                
                getsql(ages[i]+"",j+"",writer);
                
                }
            
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

    }
    
    public void getsql(String age,String benefit,BufferedWriter writer ) throws IOException{
    String url = "http://fm148.com/quotes2.php?pOne="+age+"&benefit="+benefit+"&startdate=2015-10-30&enddate=2015-10-31&submit=%E5%9C%A8%E7%BA%BF%E4%BC%B0%E4%BB%B7";
        String html = Common.getInputHtmlUTF8(url);
        String pattern = "<TABLE[^>]*?width=600 align=\"center\" border=\"1\" bordercolor=\"#00FF99\"[^>]*?>.*?</TABLE>";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(html);
        String sqlTmp = " insert into evaluate_tmp(sum_type,age,plan_key,rate,comment) values( '"+benefit+"',"+age+",";
        
        String PTR = "<TR>.*?</TR>";
        
        String ptd = "<div\\s*align=\"center\"\\s*>\\s*\\$.*?每天：\\s*\\$(([1-9]\\d{0,9})|0)(\\.\\d{1,2})<br>";
        int count =0;
        
        String title = "<div\\s*align=\"center\".*?alt=\"在线购买\"";
        String monP = "\\$[0-9]+([.]{1}[0-9]+){0,1}";
        String plan_key_start = "";
        while (m.find()) {
            Matcher mTr = Pattern.compile(PTR).matcher(m.group());
             while (mTr.find()) {
                 count++;
                 if(count<3) continue;
                 String  str = mTr.group();
               //  System.out.println(str);
                 
                 Matcher mTitle = Pattern.compile(title).matcher(str);
                 while (mTitle.find()) {
                     String  stTd = mTitle.group();
                       stTd = stTd.substring(0,stTd.indexOf("<br>"));
                        stTd =  stTd.substring(stTd.lastIndexOf(">")+1);
                        if(stTd.indexOf(" ")!=-1){
                            stTd = stTd.substring(0,stTd.indexOf(" "));
                        }
                        plan_key_start = stTd;
                 }
                 
                 Matcher mTd = Pattern.compile(ptd).matcher(str);
                 while (mTd.find()) {
                     
                     
                     String  stTd = mTd.group();
                     
                      Matcher sumTd = Pattern.compile(monP).matcher(stTd);
                      int mC = 0;
                      String sql = sqlTmp;
                       while (sumTd.find()) {
                           String sum = sumTd.group();
                           if(mC==0){
                               sql+= " '"+plan_key_start+sum.replace("$", "_")+"',";
                           }
                           if(mC==1){
                                sql+= sum.replace("$", "")+",'');";
                           }
                           mC++;
                           
                       }
                        writer.write(sql);
                        writer.newLine();//换行
                       System.out.println(sql);
                       sql = sqlTmp;
                       mC = 0;
                 }
                
             }
            
            
        }
        
        
        
//        String patternTR = "<span class=\"style4\">\\s+每天：\\$.*?</span>";
//        int count =0;
//        while (m.find()) {
//            Matcher mTr = Pattern.compile(patternTR).matcher(m.group());
//            while (mTr.find()) {
//                String  str = mTr.group();
//                System.out.println(str);
//                String startStr = "每天：$";
//                String endStr = "<br>总计:";
//                String sum =  str.substring(str.indexOf(startStr)+startStr.length(),str.indexOf(endStr));
//                sql+=","+sum;
//                count++;
//            }
//        }
//        sql+=")";
//        if(count != 21){
//            System.out.println("出错! count = " + count);
//        }
//        System.out.println(sql);
    }
    
    public void getsql1(String age,String benefit ){
        
    String url = "http://fm148.com/quotes2.php?pOne="+age+"&benefit="+benefit+"&startdate=2015-10-30&enddate=2015-10-31&submit=%E5%9C%A8%E7%BA%BF%E4%BC%B0%E4%BB%B7";
        String html = Common.getInputHtmlUTF8(url);
        String pattern = "<TABLE[^>]*?width=600 align=\"center\" border=\"1\" bordercolor=\"#00FF99\"[^>]*?>.*?</TABLE>";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(html);
        String sql = " insert into test_v values( '"+age+"','"+benefit+"'";
        String patternTR = "<span class=\"style4\">\\s+每天：\\$.*?</span>";
        int count =0;
        while (m.find()) {
            Matcher mTr = Pattern.compile(patternTR).matcher(m.group());
            while (mTr.find()) {
                String  str = mTr.group();
                System.out.println(str);
                String startStr = "每天：$";
                String endStr = "<br>总计:";
                String sum =  str.substring(str.indexOf(startStr)+startStr.length(),str.indexOf(endStr));
                sql+=","+sum;
                count++;
            }
        }
        sql+=")";
        if(count != 21){
            System.out.println("出错! count = " + count);
        }
        System.out.println(sql);
    }

}
