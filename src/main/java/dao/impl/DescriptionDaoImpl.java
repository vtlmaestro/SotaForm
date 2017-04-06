package dao.impl;

import model.Description;
import model.Task;

import java.sql.*;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */

public class DescriptionDaoImpl extends CrudDAO<Description> {

    public static final String INSERT_DESCRIPTION = "INSERT INTO description(descriptionquest) VALUES(?)";
    private static DescriptionDaoImpl crudDAO;


    public DescriptionDaoImpl(Class type) {
        super(type);
    }

    public static synchronized DescriptionDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new DescriptionDaoImpl(Description.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Description entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Description entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DESCRIPTION, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getDescriptionquest());
        return preparedStatement;
    }

    @Override
    protected List<Description> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Description> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
}

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Description entity) throws SQLException {
        return null;
    }

}
