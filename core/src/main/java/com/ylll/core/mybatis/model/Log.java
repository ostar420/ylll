package com.ylll.core.mybatis.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.ylll.core.util.JsonDateSerializer;
import javax.persistence.Table;

/**
 *
 * @author YL
 */
@Table(name = "nc_log")
public class Log  implements java.io.Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String username;
    private String module;
    private String methods;
    private String action;
    private String description;
    private String actiontime;
    private String userip;
    private Date opertime;

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getModule() {
        return module;
    }

    /**
     *
     * @param module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     *
     * @return
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     *
     * @return
     */
    public String getUserip() {
        return userip;
    }

    /**
     *
     * @param userip
     */
    public void setUserip(String userip) {
        this.userip = userip;
    }

    /**
     * 时间格式化
     *
     * @author lanyuan Email：mmm333zzz520@163.com date：2014-2-17
     * @return
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getOpertime() {
        return opertime;
    }

    /**
     *
     * @param opertime
     */
    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getActiontime() {
        return actiontime;
    }

    /**
     *
     * @param actiontime
     */
    public void setActiontime(String actiontime) {
        this.actiontime = actiontime;
    }

    /**
     * @return the methods
     */
    public String getMethods() {
        return methods;
    }

    /**
     * @param methods the methods to set
     */
    public void setMethods(String methods) {
        this.methods = methods;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}