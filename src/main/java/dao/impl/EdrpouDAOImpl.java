package dao.impl;

import model.Edrpou;

import java.sql.*;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class EdrpouDAOImpl extends CrudDAO<Edrpou>{
    public static final String INSERT_EDRPOU = "INSERT INTO inn_edrpou(edrpou) VALUES(?)";
    private static EdrpouDAOImpl crudDAO;

    public EdrpouDAOImpl(Class type) {
        super(type);
    }

    public static synchronized EdrpouDAOImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new EdrpouDAOImpl(Edrpou.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Edrpou entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Edrpou entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EDRPOU, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getEdrpou());
        return preparedStatement;
    }

    @Override
    protected List<Edrpou> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Edrpou> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Edrpou entity) throws SQLException {
        return null;
    }


    @Override
    public List<Edrpou> getListCommentById(Integer id) {
        return null;
    }
}
