package service.api;

import java.util.List;

public interface Service<K, T>{

    List<T> getAll();

    T getById(K id);

    T getUserByInnerTell(K innerTell);

    List<T> getListCommentById(K id);

    void upload(T entity);

    void delete(K key);

    void update(T entity);

    void InsertAnswer(T entity);

    T getLastId();
}
