package dao.impl;

import model.Author;
import model.Task;

import java.sql.*;
import java.util.List;


/**
 * Created by v_minjajlo on 08.11.2016.
 */
public class AuthorDaoImpl extends CrudDAO<Author> {

    public static final String INSERT_AUTHOR = "INSERT INTO author(authorquest, internaltelaut, task_id) VALUES(?, ?, (SELECT max(id) from sotaform_db.task))";
//public static final String INSERT_AUTHOR = "INSERT INTO author(authorquest, internaltelaut) VALUES(?, ?)";
    private static AuthorDaoImpl crudDAO;

    public AuthorDaoImpl(Class type) {
        super(type);
    }

    public static synchronized AuthorDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new AuthorDaoImpl(Author.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Author entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Author entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
//        PreparedStatement taskId = TaskDaoImpl.preparedStatementcreateUpdateStatement;
        preparedStatement.setString(1, entity.getAuthorNamequest());
        preparedStatement.setInt(2, entity.getInternaltelaut());
//        preparedStatement.setInt(3, entity.getTask_id());
        return preparedStatement;
    }

    @Override
    protected List<Author> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Author> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Author entity) throws SQLException {
        return null;
    }

    @Override
    public Author getUserByInnerTell(Integer innerTell) {
        return null;
    }
}
