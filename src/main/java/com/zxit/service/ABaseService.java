package com.zxit.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public interface ABaseService {
    /**
     * 通过序列名生成主键
     *
     * @param sqName
     * @return
     */
    public Long findPK(String sqName);

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

}