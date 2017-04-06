package dao.impl;

import dao.DaoFactory;
import datasource.DataSource;
import model.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public final class UserDaoImpl extends CrudDAO<User> {

    public static final String INSERT_USER = "INSERT INTO user (login, password, first_name, last_name, email, sex, innertell, role_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER = "UPDATE user SET login = ?, password = ?, first_name = ?, " +
            "last_name = ?, email = ?, sex = ?, birthday = ?, role_id = ? WHERE id = ?";
    public static final String UPDATE_USER_NAME = "UPDATE user SET first_name = ? WHERE id = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    public static final String GET_USER_BY_SEX = "SELECT * FROM user WHERE sex = ?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    private final String ENCRYPTION_PASSWORD = "SELECT MD5(\"%s\") AS PASSWORD";
    private static UserDaoImpl crudDAO;

    public UserDaoImpl(Class type) {
        super(type);
    }
    public UserDaoImpl() {
        super(User.class);
    }

//    @Override
//    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
//        setStatement(entity, preparedStatement);
//        return preparedStatement;
//    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    private void setStatement(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getSex());
        preparedStatement.setInt(7, entity.getInnerTell());
        preparedStatement.setInt(8, entity.getRole().getId());
    }


    @Override
    protected List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setSex(resultSet.getString("sex"));
            user.setInnerTell(resultSet.getInt("innerTell"));
//            user.setBirthday(resultSet.getDate("birthday").toLocalDate());
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role_id")));
            result.add(user);
        }
        return result;
    }

    @Override
    protected List<User> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, User entity) throws SQLException {
        return null;
    }


    public static synchronized UserDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new UserDaoImpl(User.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString (4, entity.getLastName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getSex());
//        preparedStatement.setDate (7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setInt(7, entity.getInnerTell());
        preparedStatement.setInt(8, entity.getRole().getId());
        preparedStatement.setInt(9, entity.getId());
        return preparedStatement;
    }
////
//    @Override
//    protected PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.setString(1, entity.getLogin());
//        preparedStatement.setString(2, this.encryptPassword(entity.getPassword()));
//        preparedStatement.setString(3, entity.getFirstName());
//        preparedStatement.setString (4, entity.getLastName());
//        preparedStatement.setString(5, entity.getEmail());
//        preparedStatement.setString(6, entity.getSex());
//        preparedStatement.setDate (7, Date.valueOf(entity.getBirthday()));
//        preparedStatement.setInt(8, entity.getRole().getId());
//        return preparedStatement;
//    }
////
//    @Override
//    public List<User> readAll(ResultSet resultSet) throws SQLException {
//        List<User> result = new LinkedList<>();
//        User user = null;
//        while (resultSet.next()) {
//            user = new User();
//            user.setId(resultSet.getInt("id"));
//            user.setFirstName(resultSet.getString("first_name"));
//            user.setLastName(resultSet.getString("last_name"));
//            user.setLogin(resultSet.getString("login"));
//            user.setPassword(resultSet.getString("password"));
//            user.setSex(resultSet.getString("sex"));
//            user.setRole(new RoleDaoImpl(Role.class).getById(resultSet.getInt("role_id")));
//            result.add(user);
//        }
//        return result;
//    }
////
//    public void updateUserNameById(String name, Integer id) {
//        Connection connection = DataSource.getInstance().getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_NAME);
//            preparedStatement.setString(1, name);
//            preparedStatement.setInt(2, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public User getUserByName(String name) {
//        Connection connection = DataSource.getInstance().getConnection();
//        List<User> result = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
//            preparedStatement.setString(1, name);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            result = readAll(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return  result.get(0);
//    }

//    public List<User> getUserBySex (String sex) {
//        Connection connection = DataSource.getInstance().getConnection();
//        List<User> result = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_SEX);
//            preparedStatement.setString(1, sex);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            result = readAll(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for (User movie : result) {
//            System.out.println(movie);
//        }
//        return  result;
//    }
//    public User getUserByEmail (String email) {
//        Connection connection = DataSource.getInstance().getConnection();
//        List<User> result = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL);
//            preparedStatement.setString(1, email);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            result = readAll(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return  result.get(0);
//    }

    public String encryptPassword(String password) {
        Connection connection = DataSource.getInstance().getConnection();
        String encryptedPassword = null;
        String sql = String.format(ENCRYPTION_PASSWORD, password);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                encryptedPassword = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }


    @Override
    public List<User> getListCommentById(Integer id) {
        return null;
    }
}
