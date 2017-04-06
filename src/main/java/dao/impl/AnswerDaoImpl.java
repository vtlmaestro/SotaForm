package dao.impl;

import dao.api.Dao;
import model.AnswerTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by v_minjajlo on 08.02.2017.
 */
public class AnswerDaoImpl extends CrudDAO<AnswerTask> {

    private static AnswerDaoImpl crudDAO;

    public static final String INSERT_ANSWER = "INSERT INTO answertask(id, comment, author, time) VALUES(?, ?, ?, ?)";


    public AnswerDaoImpl(Class type) {
        super(type);
    }

    public static synchronized AnswerDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new AnswerDaoImpl(AnswerTask.class);
        }
        return crudDAO;
    }


    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, AnswerTask entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, AnswerTask entity) throws SQLException {
        return null;
    }

    @Override
    protected List<AnswerTask> readAll(ResultSet resultSet) throws SQLException {
        List<AnswerTask> result = new LinkedList<>();
        AnswerTask answerTask = null;
        while (resultSet.next()) {
            answerTask = new AnswerTask();
            answerTask.setId(resultSet.getInt("id"));
            answerTask.setComment(resultSet.getString("comment"));
            answerTask.setNameAuthor(resultSet.getString("author"));
            answerTask.setTime(resultSet.getString("time"));
            result.add(answerTask);
        }
        return result;
    }

    @Override
    protected List<AnswerTask> readListAllComment(ResultSet resultSet) throws SQLException {
        List<AnswerTask> result = new LinkedList<>();
        AnswerTask answerTask = null;
        while (resultSet.next()) {
            answerTask = new AnswerTask();
            answerTask.setId(resultSet.getInt("id"));
            answerTask.setComment(resultSet.getString("comment"));
            answerTask.setNameAuthor(resultSet.getString("author"));
            answerTask.setTime(resultSet.getString("time"));
            result.add(answerTask);
        }
        return result;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return 0;
    }

    @Override
    protected PreparedStatement InsertAnsw(Connection connection, AnswerTask entity) throws SQLException {
        PreparedStatement preparedStatementInsertAnswerStatement = connection.prepareStatement(INSERT_ANSWER);
        preparedStatementInsertAnswerStatement.setInt(1, entity.getId());
        preparedStatementInsertAnswerStatement.setString(2, entity.getComment());
        preparedStatementInsertAnswerStatement.setString(3, entity.getNameAuthor());
        preparedStatementInsertAnswerStatement.setString(4, entity.getTime());
        return preparedStatementInsertAnswerStatement;
    }


    @Override
    public AnswerTask getUserByInnerTell(Integer innerTell) {
        return null;
    }
}
