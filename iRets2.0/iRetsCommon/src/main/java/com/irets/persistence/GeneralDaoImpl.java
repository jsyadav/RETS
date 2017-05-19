package com.irets.persistence;import com.irets.exception.ObjectNotFoundException;import com.irets.logging.domain.AppLogger;import com.ibatis.sqlmap.client.SqlMapClient;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.annotation.Required;import org.springframework.orm.ibatis.SqlMapClientTemplate;import org.springframework.util.ClassUtils;import java.io.Serializable;import java.util.List;/** * Implementation of the general DAO. * Base class for DAO. */public abstract class GeneralDaoImpl<T, PK extends Serializable> implements GeneralDao<T, PK> {    private static int selectNumber = 0;    AppLogger log = AppLogger.getLogger(getClass());    protected Class<T> persistentClass;    private SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate();    protected GeneralDaoImpl(Class<T> persistentClass) {        this.persistentClass = persistentClass;    }    @Autowired    @Required    public final void setSqlMapClient(SqlMapClient sqlMapClient) {        this.sqlMapClientTemplate.setSqlMapClient(sqlMapClient);    }    public Class<T> getPersistentClass() {        return persistentClass;    }    protected SqlMapClientTemplate getSqlMapClientTemplate() {        return sqlMapClientTemplate;    }    @SuppressWarnings("unchecked")    public List<T> getAll() {        long timeStamp = System.currentTimeMillis();        String queryName = getSelectQuery(ClassUtils.getShortName(this.persistentClass));        try {            return getSqlMapClientTemplate().queryForList(queryName, null);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }    }    @SuppressWarnings("unchecked")    public List<T> getSubList(int skip, int max) {        long timeStamp = System.currentTimeMillis();        String queryName = getSelectQuery(ClassUtils.getShortName(this.persistentClass));        try {            return getSqlMapClientTemplate().queryForList(queryName, null, skip, max);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }    }    @SuppressWarnings("unchecked")    public T get(PK id) throws ObjectNotFoundException {        long timeStamp = System.currentTimeMillis();        String queryName = getFindQuery(ClassUtils.getShortName(this.persistentClass));        T object;        try {            object = (T) getSqlMapClientTemplate().queryForObject(queryName, id);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }        if (object == null) {            log.debug(this.persistentClass + "' object with id '" + id + "' was not found");            throw new ObjectNotFoundException();        }        return object;    }    @SuppressWarnings("unchecked")    public boolean exists(PK id) {        long timeStamp = System.currentTimeMillis();        String queryName = getFindQuery(ClassUtils.getShortName(this.persistentClass));        T object;        try {            object = (T) getSqlMapClientTemplate().queryForObject(queryName, id);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }        return object != null;    }    public int save(T object) {        long timeStamp = System.currentTimeMillis();        String queryName = getUpdateQuery(ClassUtils.getShortName(this.persistentClass));        try {            return getSqlMapClientTemplate().update(queryName, object);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms.");            }        }    }    @SuppressWarnings("unchecked")    public PK create(T object) {        long timeStamp = System.currentTimeMillis();        String queryName = getInsertQuery(ClassUtils.getShortName(this.persistentClass));        try {            return (PK) getSqlMapClientTemplate().insert(queryName, object);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms.");            }        }    }    public int delete(PK id) {        long timeStamp = System.currentTimeMillis();        String queryName = getInsertQuery(ClassUtils.getShortName(this.persistentClass));        try {            return getSqlMapClientTemplate().update                    (getDeleteQuery(ClassUtils.getShortName(this.persistentClass)), id);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms.");            }        }    }    protected Object getByQueryName(String queryName, Object criteria) {        long timeStamp = System.currentTimeMillis();        try {            return getSqlMapClientTemplate().queryForObject (queryName, criteria);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }    }    protected List listByQueryName(String queryName, Object criteria) {        long timeStamp = System.currentTimeMillis();        try {            return getSqlMapClientTemplate().queryForList(queryName, criteria);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }    }    protected List listByQueryName(String queryName, Object criteria, int skip, int max) {        long timeStamp = System.currentTimeMillis();        try {            return getSqlMapClientTemplate().queryForList(queryName, criteria, skip, max);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms. "+selectNumber++);            }        }    }    protected Serializable insert(String queryName, Object data) {        long timeStamp = System.currentTimeMillis();        try {            return (Serializable)getSqlMapClientTemplate().insert(queryName, data);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms.");            }        }    }    protected int update(String queryName, Object data) {        long timeStamp = System.currentTimeMillis();        try {            return getSqlMapClientTemplate().update(queryName, data);        } finally {            if (log.isDebugEnabled()) {                log.debug(queryName+" "+(System.currentTimeMillis()-timeStamp)+"ms.");            }        }    }    /**     * @param className the name of the class - returns "get" + className + "s"     * @return Returns the select query name.     */    protected String getSelectQuery(String className) {        return DaoUtil.getSelectQuery(className);    }    /**     * @param className the name of the class - returns "get" + className     * @return Returns the find query name.     */    protected String getFindQuery(String className) {        return DaoUtil.getFindQuery(className);    }    /**     * @param className the name of the class - returns "add" + className     * @return Returns the insert query name.     */    protected String getInsertQuery(String className) {        return DaoUtil.getInsertQuery(className);    }    /**     * @param className the name of the class - returns "update" + className     * @return Returns the update query name.     */    protected String getUpdateQuery(String className) {        return DaoUtil.getUpdateQuery(className);    }    /**     * @param className the name of the class - returns "delete" + className     * @return Returns the delete query name.     */    protected String getDeleteQuery(String className) {        return DaoUtil.getDeleteQuery(className);    }}