package dao.impl;

import datasource.DataSource;
import model.Role;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public final class RoleDaoImpl extends CrudDAO<Role> {
    public static final String INSERT_ROLE = "INSERT INTO role (role_name) VALUES (?)";
    public static final String UPDATE_ROLE = "UPDATE role SET role_name = ? WHERE id = ?";
    public static final String GET_ROLE_BY_NAME = "SELECT * FROM role WHERE role_name LIKE ?";

    private static RoleDaoImpl crudDAO;

    public RoleDaoImpl(Class type) {
        super(type);
    }


    public static synchronized RoleDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new RoleDaoImpl(Role.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Role entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Role entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROLE, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getName());
//        preparedStatement.setInt(2, entity.getId());
        return preparedStatement;
    }

    @Override
    public List<Role> readAll(ResultSet resultSet) throws SQLException {
        List<Role> result = new LinkedList<>();
        Role hall = null;
        while (resultSet.next()) {
            hall = new Role();
            hall.setId(resultSet.getInt("id"));
            hall.setName(resultSet.getString("role_name"));
            result.add(hall);
        }
        return result;
    }

    @Override
    protected List<Role> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Role entity) throws SQLException {
        return null;
    }


    public Role getRoleByName(String name) {
        Connection connection = DataSource.getInstance().getConnection();
        List<Role> result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.get(0);
    }



    @Override
    public List<Role> getListCommentById(Integer id) {
        return null;
    }
}
