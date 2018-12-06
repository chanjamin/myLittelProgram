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
 * TB_ORDER_SHIPPING
 * 
 * @author bianj
 * @version 1.0.0 2017-09-21
 */
public class OrderShipping implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3771954066581560747L;

    /** 订单ID */
    private String orderId;

    /** 收货人全名 */
    private String receiverName;

    /** 固定电话 */
    private String receiverPhone;

    /** 移动电话 */
    private String receiverMobile;

    /** 省份 */
    private String receiverState;

    /** 城市 */
    private String receiverCity;

    /** 区/县 */
    private String receiverDistrict;

    /** 收货地址，如：xx路xx号 */
    private String receiverAddress;

    /** 邮政编码,如：310001 */
    private String receiverZip;

    /**  */
    private Date created;

    /**  */
    private Date updated;

    /**
     * 获取订单ID
     * 
     * @return 订单ID
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * 设置订单ID
     * 
     * @param orderId
     *          订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取收货人全名
     * 
     * @return 收货人全名
     */
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置收货人全名
     * 
     * @param receiverName
     *          收货人全名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取固定电话
     * 
     * @return 固定电话
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置固定电话
     * 
     * @param receiverPhone
     *          固定电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取移动电话
     * 
     * @return 移动电话
     */
    public String getReceiverMobile() {
        return this.receiverMobile;
    }

    /**
     * 设置移动电话
     * 
     * @param receiverMobile
     *          移动电话
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * 获取省份
     * 
     * @return 省份
     */
    public String getReceiverState() {
        return this.receiverState;
    }

    /**
     * 设置省份
     * 
     * @param receiverState
     *          省份
     */
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    /**
     * 获取城市
     * 
     * @return 城市
     */
    public String getReceiverCity() {
        return this.receiverCity;
    }

    /**
     * 设置城市
     * 
     * @param receiverCity
     *          城市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * 获取区/县
     * 
     * @return 区/县
     */
    public String getReceiverDistrict() {
        return this.receiverDistrict;
    }

    /**
     * 设置区/县
     * 
     * @param receiverDistrict
     *          区/县
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * 获取收货地址，如：xx路xx号
     * 
     * @return 收货地址
     */
    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    /**
     * 设置收货地址，如：xx路xx号
     * 
     * @param receiverAddress
     *          收货地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取邮政编码,如：310001
     * 
     * @return 邮政编码
     */
    public String getReceiverZip() {
        return this.receiverZip;
    }

    /**
     * 设置邮政编码,如：310001
     * 
     * @param receiverZip
     *          邮政编码
     */
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
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
}