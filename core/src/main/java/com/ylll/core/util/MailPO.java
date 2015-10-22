/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.util;

import java.util.Date;

/**
 *
 * @author YL
 */
public class MailPO {

    private String id;
    private String sendId;
    private Date sendTime;
    private String sendMail;
    private String ip;
    private String port;
    private String title;
    private String content;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the sendId
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * @param sendId the sendId to set
     */
    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    /**
     * @return the sendTime
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime the sendTime to set
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return the sendMail
     */
    public String getSendMail() {
        return sendMail;
    }

    /**
     * @param sendMail the sendMail to set
     */
    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
