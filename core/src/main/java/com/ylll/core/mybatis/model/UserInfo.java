package com.ylll.core.mybatis.model;

import com.ylll.core.util.JsonDateSerializer;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *  用户信息表
 */
@Table(name = "user_info")
public class UserInfo implements java.io.Serializable{
    
    @Id
    @NotEmpty
    @Length(max=32)
    private String id;
    
    @NotEmpty
    @Length(max=50)
    private String name;
    
    @Length(max=50)
    private String tel;
    
    @Length(max=50)
    private String phone;
    
    @Email
    @Length(max=50)
    private String email;
    
    @Length(max=200)
    private String address;
    
    
    @Column(name = "oper_time")
    private Date opertime;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 时间格式化
     * @return the opertime
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getOpertime() {
        return opertime;
    }

    /**
     * @param opertime the opertime to set
     */
    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }
    
}
