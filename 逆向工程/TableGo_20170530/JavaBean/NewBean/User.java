/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.0.0
 */

import java.util.Date;

/**
 * 用户表(TB_USER)
 * 
 * @author bianj
 * @version 1.0.0 2017-09-21
 */
public class User implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -182296808335173292L;

    /**  */
    private Long id;

    /** 用户名 */
    private String username;

    /** 密码，加密存储 */
    private String password;

    /** 注册手机号 */
    private String phone;

    /** 注册邮箱 */
    private String email;

    /**  */
    private Date created;

    /**  */
    private Date updated;

    /**  */
    private Integer gid;

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
     *          密码
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
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置
     * 
     * @param gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }
}