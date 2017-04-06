package dao.impl;

import datasource.DataSource;
import model.Task;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public final class TaskDaoImpl extends CrudDAO<Task> {

    private static TaskDaoImpl crudDAO;

//    public static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID ()";
//    public static final String INSERT_TASK = "INSERT INTO task(datetask, description, texterror, contentdownloads) VALUES(?, ?, ?, ?)";
    public static final String INSERT_TASK = "INSERT INTO task(datetask, description, texterror, subject) VALUES(?, ?, ?, ?)";

    public static final String UPDATE_TASK = "UPDATE task SET texterror = ?, datetask = ?, description = ?, subject = ? WHERE id = ?";
//    public static final String UPDATE_TASK = "UPDATE task SET texterror = ? WHERE id = ?";
    public static final String GET_MOVIE_BY_TITLE = "SELECT * FROM movie WHERE title LIKE ?";
    public static final String GET_MOVIE_BY_START = "SELECT * FROM movie WHERE rent_start >= CAST(? AS DATE)";
    public static final String GET_MOVIE_BY_END = "SELECT * FROM movie WHERE rent_start <= CAST(? AS DATE)";
    public static final String INSERT_ANSWER = "INSERT INTO answertask(comment, task_id) VALUES(?, ?)";


    public TaskDaoImpl(Class type) {
        super(type);
    }

    public static synchronized TaskDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new TaskDaoImpl(Task.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Task entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK);
//        preparedStatement.setString(1, entity.getTexterrorDTO());
//        preparedStatement.setString(2, entity.getAuthorquest());
//        preparedStatement.setInt(3, entity.getPhoneauthorquest());
//        preparedStatement.setDate(4, DateDTO.valueOf(entity.getDatetask()));
//        preparedStatement.setString(5, entity.getDescription());
//        preparedStatement.setString(6, entity.getEmail());
//        preparedStatement.setInt(7, entity.getEdrpou());
//        preparedStatement.setInt(8, entity.getPhoneclient());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Task entity) throws SQLException {
        PreparedStatement preparedStatementCreateInsertStatement = connection.prepareStatement(INSERT_TASK, Statement.RETURN_GENERATED_KEYS);
        preparedStatementCreateInsertStatement.setString(1, entity.getDateTask());
        preparedStatementCreateInsertStatement.setString(2, entity.getDescription());
        preparedStatementCreateInsertStatement.setString(3, entity.getTextError());
        preparedStatementCreateInsertStatement.setString(4, entity.getSubject());
        return preparedStatementCreateInsertStatement;
    }

    @Override
    protected PreparedStatement InsertAnsw(Connection connection, Task entity) throws SQLException {
        PreparedStatement updateAnswer = connection.prepareStatement(INSERT_ANSWER);
        updateAnswer.setString(1, entity.getAnswer());
        updateAnswer.setInt(2, entity.getId());
        return updateAnswer;
    }


    @Override
    public List<Task> readAll(ResultSet resultSet) throws SQLException {
        List<Task> result = new LinkedList<>();
        Task task = null;
        while (resultSet.next()) {
            task = new Task();
            task.setId(resultSet.getInt("id"));
            task.setTextError(resultSet.getString("texterror"));
            task.setDescription(resultSet.getString("description"));
            task.setDateTask(resultSet.getString("datetask"));
            task.setSubject(resultSet.getString("subject"));
            result.add(task);
        }
        return result;
    }

    @Override
    protected List<Task> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        int result = 0;
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            result = generatedKeys.getInt(1);
        }
//        while (resultSet.next()) {
//            result = resultSet.getInt(1);
//        }
        return result;
    }


    public int getTaskId() {
        int result = -1;
        Connection connection = DataSource.getInstance().getConnection();
        Task task = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_ID, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
//               task.setId(resultSet.getInt(1));
                result = resultSet.getInt("id");
                result = 12;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateMovieTitleById(String title, Integer id) {
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Task getMovieByTitle(String title) {
        Connection connection = DataSource.getInstance().getConnection();
        List<Task> result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MOVIE_BY_TITLE);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.get(0);
    }

    public List<Task> getMovieByStartDate(String start) {
        Connection connection = DataSource.getInstance().getConnection();
        List<Task> result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MOVIE_BY_START);
            preparedStatement.setString(1, start);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Task task : result) {
            System.out.println(task);
        }
        return result;
    }


    public List<Task> getMovieByEndDate(String end) {
        Connection connection = DataSource.getInstance().getConnection();
        List<Task> result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MOVIE_BY_END);
            preparedStatement.setString(1, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Task task : result) {
            System.out.println(task);
        }
        return result;
    }


    @Override
    public List<Task> getListCommentById(Integer id) {
        return null;
    }
}