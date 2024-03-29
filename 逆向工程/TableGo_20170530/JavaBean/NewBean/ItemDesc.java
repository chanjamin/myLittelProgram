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
 * 商品描述表(TB_ITEM_DESC)
 * 
 * @author bianj
 * @version 1.0.0 2017-09-21
 */
public class ItemDesc implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5381135202996058219L;

    /** 商品ID */
    private Long itemId;

    /** 商品描述 */
    private String itemDesc;

    /** 创建时间 */
    private Date created;

    /** 更新时间 */
    private Date updated;

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
     * 获取商品描述
     * 
     * @return 商品描述
     */
    public String getItemDesc() {
        return this.itemDesc;
    }

    /**
     * 设置商品描述
     * 
     * @param itemDesc
     *          商品描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreated() {
        return this.created;
    }

    /**
     * 设置创建时间
     * 
     * @param created
     *          创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     * 
     * @return 更新时间
     */
    public Date getUpdated() {
        return this.updated;
    }

    /**
     * 设置更新时间
     * 
     * @param updated
     *          更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}