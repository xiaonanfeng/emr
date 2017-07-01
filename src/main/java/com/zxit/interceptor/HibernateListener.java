package com.zxit.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.type.Type;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;

/**
 * 作废
 *
 * @author Administrator
 */
//@Component
@Deprecated
@SuppressWarnings({"serial", "rawtypes"})
public class HibernateListener extends EmptyInterceptor {

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state,
                         String[] propertyNames, Type[] types) {
        //System.out.println("delete..............");  
        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id,
                                Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) {
        // System.out.println("flushDirty..............");
        return super.onFlushDirty(entity, id, currentState, previousState,
                propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state,
                          String[] propertyNames, Type[] types) {
        // System.out.println("save..............");
        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public void onCollectionRecreate(Object collection, Serializable key)
            throws CallbackException {
        //System.out.println("recreate..............");  
        super.onCollectionRecreate(collection, key);
    }

    @Override
    public void onCollectionRemove(Object collection, Serializable key)
            throws CallbackException {
        // System.out.println("remove..............");
        super.onCollectionRemove(collection, key);
    }

    @Override
    public void onCollectionUpdate(Object collection, Serializable key)
            throws CallbackException {
        System.out.println("collectionUpdate.............." + collection);
        super.onCollectionUpdate(collection, key);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state,
                          String[] propertyNames, Type[] types) {
        // System.out.println("load..............");
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public void postFlush(Iterator entities) {
        //System.out.println("flush.............."+entities);  
        super.postFlush(entities);
    }

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("statement.............." + sql);
        return super.onPrepareStatement(sql);
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("preflush..............");
        super.preFlush(entities);
    }

}  
