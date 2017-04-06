package dao.impl;

import model.PhoneClient;

import java.sql.*;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class PhoneClientDAOImp extends CrudDAO<PhoneClient> {
    public static final String INSERT_PHONE = "INSERT INTO phoneclient(phone) VALUES(?)";

    public PhoneClientDAOImp(Class type) {
        super(type);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, PhoneClient entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, PhoneClient entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONE, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getPhone());
        return preparedStatement;
    }

    @Override
    protected List<PhoneClient> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<PhoneClient> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, PhoneClient entity) throws SQLException {
        return null;
    }

    @Override
    public PhoneClient getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<PhoneClient> getListCommentById(Integer id) {
        return null;
    }
}
