package dao.api;


import model.Entity;

import java.util.List;

public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();

    T getById(K key);

    T getUserByInnerTell(K innerTell);

    List<T> getListCommentById(K id);

    T getBy(String fieldName, String value);

    void upload(T entity);

    void delete(K key);

    void update(T entity);

    void InsertAnswer(T entity);

    T getLastId();
}
