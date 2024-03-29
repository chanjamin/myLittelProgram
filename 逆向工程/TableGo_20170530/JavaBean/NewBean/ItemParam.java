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
 * 商品规则参数(TB_ITEM_PARAM)
 * 
 * @author bianj
 * @version 1.0.0 2017-09-21
 */
public class ItemParam implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1498358948982265139L;

    /**  */
    private Long id;

    /** 商品类目ID */
    private Long itemCatId;

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
     * 获取商品类目ID
     * 
     * @return 商品类目ID
     */
    public Long getItemCatId() {
        return this.itemCatId;
    }

    /**
     * 设置商品类目ID
     * 
     * @param itemCatId
     *          商品类目ID
     */
    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
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