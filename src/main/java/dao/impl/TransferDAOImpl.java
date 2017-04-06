package dao.impl;

import model.Transfer;
import java.sql.*;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class TransferDAOImpl extends CrudDAO<Transfer> {

    private static TransferDAOImpl crudDAO;

    public static final String INSERT_TRANSFER = "INSERT INTO transfer(id, oldaccount, newaccount) VALUES((SELECT max(id) from sotaform_db.task), ?, ?)";

    public TransferDAOImpl(Class type) {
        super(type);
    }
    public static synchronized TransferDAOImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new TransferDAOImpl(Transfer.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Transfer entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Transfer entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSFER, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getOldaccount());
        preparedStatement.setString(2, entity.getNewaccount());
        return preparedStatement;
    }

    @Override
    protected List<Transfer> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<Transfer> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Transfer entity) throws SQLException {
        return null;
    }


    @Override
    public List<Transfer> getListCommentById(Integer id) {
        return null;
    }
}
