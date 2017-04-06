package dao.impl;

import model.Email;

import java.sql.*;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class EmailDAOImpl extends CrudDAO<Email> {
    public static final String INSERT_EMAIL = "INSERT INTO email(emailclient, task_id) VALUES(?, (SELECT max(id) from sotaform_db.task))";
    private static EmailDAOImpl crudDAO;

    public EmailDAOImpl(Class type) {
        super(type);
    }
    public static synchronized EmailDAOImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new EmailDAOImpl(Email.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Email entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Email entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMAIL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getEmailclient());
        return preparedStatement;
    }

    @Override
    protected List<Email> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Email> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Email entity) throws SQLException {
        return null;
    }

    @Override
    public List<Email> getListCommentById(Integer id) {
        return null;
    }
}
