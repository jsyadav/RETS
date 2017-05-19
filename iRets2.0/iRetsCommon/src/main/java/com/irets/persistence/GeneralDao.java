package com.irets.persistence;import com.irets.exception.ObjectNotFoundException;import java.io.Serializable;import java.util.List;/** * Inheritable general DAO for CRUD operations. */public interface GeneralDao <T, PK extends Serializable> {    /**     * Gets all objects.     *     * @return list of objects     */    List<T> getAll();    /**     * Gets all objects.     *     * @param skip number of results to ignore.     * @param max maximum number of results to return     * @return list of objects.     */    List<T> getSubList(int skip, int max);    /**     * Load object by ID.     *     * @param id object ID.     * @return object.     * @throws ObjectNotFoundException if object was not found.     */    T get(PK id) throws ObjectNotFoundException;    /**     * Checks for existence of an object.     *     * @param id the id of the entity     * @return - true if it exists, false if it doesn't     */    boolean exists(PK id);    /**     * Generic method to save an object.     *     * @param object the object to save     * @return number of updated rows.     */    int save(T object);    /**     * Creates new object.     *     * @param object object properties.     * @return ID of the new object.     */    PK create(T object);    /**     * Generic method to delete an object based     *     * @param id the identifier (primary key).     * @return number of deleted rows.     */    int delete(PK id);}