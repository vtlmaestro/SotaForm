package dao.impl;

import model.Date;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class DateDAOImpl extends CrudDAO<Date> {


    public DateDAOImpl(Class type) {
        super(type);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Date entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Date entity) throws SQLException {
        return null;
    }

    @Override
    protected List<Date> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Date> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Date entity) throws SQLException {
        return null;
    }

}
