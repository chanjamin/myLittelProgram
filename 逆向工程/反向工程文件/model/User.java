/******************************************************************
** 类    名：User
** 描    述：用户表
** 创 建 者：shenkunlin
** 创建时间：2017-07-17 06:05:00
******************************************************************/

package com.taotao.manager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户表(TB_USER)
 * 
 * @author shenkunlin
 * @version 1.0.0 2017-07-17
 */
@Entity
@Table(name = "TB_USER")
public class User implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1645868150103854246L;
    
    /**  */
    @Column(name = "ID")
    private Long id;
    
    /** 用户名 */
    @Column(name = "USERNAME")
    private String username;
    
    /** 密码，加密存储 */
    @Column(name = "PASSWORD")
    private String password;
    
    /** 注册手机号 */
    @Column(name = "PHONE")
    private String phone;
    
    /** 注册邮箱 */
    @Column(name = "EMAIL")
    private String email;
    
    /**  */
    @Column(name = "CREATED")
    private Date created;
    
    /**  */
    @Column(name = "UPDATED")
    private Date updated;
    
    /**
     * 获取
     * 
     * @return 
     */
    public Long getId() {
        return this.id;
    }
     
    /**
     * 设置
     * 
     * @param id
     *          
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUsername() {
        return this.username;
    }
     
    /**
     * 设置用户名
     * 
     * @param username
     *          用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * 获取密码，加密存储
     * 
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }
     
    /**
     * 设置密码，加密存储
     * 
     * @param password
     *          密码，加密存储
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 获取注册手机号
     * 
     * @return 注册手机号
     */
    public String getPhone() {
        return this.phone;
    }
     
    /**
     * 设置注册手机号
     * 
     * @param phone
     *          注册手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * 获取注册邮箱
     * 
     * @return 注册邮箱
     */
    public String getEmail() {
        return this.email;
    }
     
    /**
     * 设置注册邮箱
     * 
     * @param email
     *          注册邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Date getCreated() {
        return this.created;
    }
     
    /**
     * 设置
     * 
     * @param created
     *          
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Date getUpdated() {
        return this.updated;
    }
     
    /**
     * 设置
     * 
     * @param updated
     *          
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}