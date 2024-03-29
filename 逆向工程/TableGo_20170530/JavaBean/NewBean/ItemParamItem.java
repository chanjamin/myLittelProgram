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
 * 商品规格和商品的关系表(TB_ITEM_PARAM_ITEM)
 * 
 * @author bianj
 * @version 1.0.0 2017-09-21
 */
public class ItemParamItem implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -404674283498939895L;

    /**  */
    private Long id;

    /** 商品ID */
    private Long itemId;

    /** 参数数据，格式为json格式 */
    private String paramData;

    /**  */
    private Date created;

    /**  */
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
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品ID
     * 
     * @return 商品ID
     */
    public Long getItemId() {
        return this.itemId;
    }

    /**
     * 设置商品ID
     * 
     * @param itemId
     *          商品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取参数数据，格式为json格式
     * 
     * @return 参数数据
     */
    public String getParamData() {
        return this.paramData;
    }

    /**
     * 设置参数数据，格式为json格式
     * 
     * @param paramData
     *          参数数据
     */
    public void setParamData(String paramData) {
        this.paramData = paramData;
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