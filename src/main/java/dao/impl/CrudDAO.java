package dao.impl;


import dao.api.Dao;
import datasource.DataSource;
import model.Entity;
import model.Task;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static dao.impl.UserDaoImpl.GET_USER_BY_LOGIN;

public abstract class CrudDAO<T extends Entity<Integer>> implements Dao<Integer, T> {

    public static int LAST_TASK_ID;
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY_INNERTELL = "Select * from %s where innertell = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";
//    public static final String SELECT_LAST_ID = "SELECT LAST_INSERT_ID()";
    public static final String SELECT_LAST_ID = "SELECT max(id) from sotaform_db.task";
    private Class<T> type;
    private DataSource dataSource;

    public CrudDAO(Class<T>  type) {
        this.type = type;
        dataSource = DataSource.getInstance();
    }


    @Override
    public T getLastId() {
        String sql = String.format(SELECT_LAST_ID);
        Task result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            result.setId(getLastInsertId(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  (T) result;
    }

    @Override
    public List<T> getAll() {
        String sql = String.format(SELECT_ALL, type.getSimpleName());

        List result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();){
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public T getBy(String fieldName, String value) {
        String sql = String.format(GET_USER_BY_LOGIN, type.getSimpleName(), fieldName);
        Connection connection = dataSource.getConnection();
        List result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (result.size() > 0) ? (T) result.get(0) : null;
    }

    @Override
    public List<T> getListCommentById(Integer id) {
        String sql = String.format(FIND_BY_ID, type.getSimpleName());
        Connection connection = dataSource.getConnection();
        List resultComment = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultComment = readListAllComment(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultComment;
    }

    @Override
    public T getById(Integer id) {
        String sql = String.format(FIND_BY_ID, type.getSimpleName());
        Connection connection = dataSource.getConnection();
        List result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) result.get(0);
    }

    @Override
    public T getUserByInnerTell(Integer innerTell) {
        String sql = String.format(FIND_BY_INNERTELL, type.getSimpleName());
        Connection connection = dataSource.getConnection();
        List result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, innerTell);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) result.get(0);
    }

    @Override
    public void upload(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = createInsertStatement(connection, entity)){
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getInt(1));
                LAST_TASK_ID = entity.getId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = createUpdateStatement(connection, entity)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void InsertAnswer(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = InsertAnsw(connection, entity)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer key) {
        String sql = String.format(DELETE_BY_ID, type.getSimpleName());

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract PreparedStatement createUpdateStatement(Connection connection, T entity) throws SQLException;

    protected abstract PreparedStatement createInsertStatement(Connection connection, T entity) throws SQLException;

    protected abstract List<T> readAll(ResultSet resultSet) throws SQLException;

    protected abstract List<T> readListAllComment(ResultSet resultSet) throws SQLException;

    protected abstract int getLastInsertId(ResultSet resultSet) throws SQLException;

    protected abstract PreparedStatement InsertAnsw(Connection connection, T entity) throws SQLException;
}
