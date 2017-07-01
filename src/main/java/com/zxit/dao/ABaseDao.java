package com.zxit.dao;

import java.io.Serializable;
import java.sql.Clob;
import java.util.List;


import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 一些说明：
 * 1，load和get
 * 性能上没有什么特殊的要求
 * 全部用get，load对于这种政府级项目只是吹毛求疵。
 * <p>
 * 2，flush小心点用，没有必要的话 ，别用就行了。
 * <p>
 * 3，带分页的SQL，不写了，还没JDBC好用。
 * <p>
 * 4，别没事儿非要操作游离对象，重新来一遍比找错误快得多
 * <p>
 * 5，
 */
public interface ABaseDao {
    /**
     * 通过id查找对象
     */
    public <T> T findById(Class<T> type, Serializable id);

    /**
     * 通过对象查出所有列表
     */
    public <T> List<T> findAll(Class<T> type);

    /**
     * 通过一个hql得到Query
     */
    public Query findByHQL(String hql);

    /**
     * 获得信息个数HQL
     */
    public int findTotalByHQL(String hql);

    /**
     * 带分页查询
     */
    public <T> List<T> findWithPager(Class<T> type, String hql, int startNum, int pageTotal);

    /**
     * 带in的分组
     */
    public <T> List<T> findWithPagerAndCollections(Class<T> type, String hql, Map<String, Object> map, int startNum, int pageTotal);

    /**
     * 通过一个sql得到一个Query对象
     */
    public SQLQuery findBySQL(String sql);

    /**
     * 获得信息个数SQL
     */
    public int findTotalBySQL(String sql);
    /**
     * 带分页的Sql查询
     */
    //public <T> List<T> findWithPagerSQL(String sql, int startNum,int pageTotal);

    /**
     * 保存，你懂的
     */
    public void save(Object... entities);

    /**
     * 更新，你也懂得
     */
    public void updateObjects(Object... entities);

    public void update(Object entity);

    /**
     * 持久化
     */
    public void merge(Object entity);

    /**
     * 更新或保存
     */
    public void saveOrUpdate(Object entity);

    /**
     * 删除，不多说
     */
    public void delete(Object... entities);

    /**
     * 主键删除
     */
    public void deleteById(Class<?> type, Serializable id);

    /**
     * 刷新数据库对象
     *
     * @param entities
     */
    public void refresh(Object... entities);

    /**
     * 同步数据库对象，执行 在事务提交之前
     */
    public void flush();

    /**
     * 清理session缓存
     */
    public void clear();

    /**
     * 通过String 创建一个lob
     */
    public Clob createClob(String str);

    /**
     * 创造一个Criteria 实例
     */
    public Criteria createCriteria(Class<?> type);


    /**
     * 从存储过程找到列表
     * @param type
     * @param key
     * @return
     */
//	public  CachedRowSet findProcedures(Integer key);

}
