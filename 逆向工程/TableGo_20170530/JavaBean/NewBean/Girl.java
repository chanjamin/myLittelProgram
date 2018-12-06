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

/**
 * GIRL
 * 
 * @author bianj
 * @version 1.0.0 2017-09-21
 */
public class Girl implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -5983127997726073380L;

    /**  */
    private Integer id;

    /**  */
    private String name;

    /**
     * 获取
     * 
     * @return 
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}