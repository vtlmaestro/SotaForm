package dao.impl;

import model.Client;
import model.Task;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by v_minjajlo on 14.12.2016.
 */
public class ClientDaoImpl extends CrudDAO<Client> {

    private static ClientDaoImpl crudDAO;
    public static final String INSERT_CLIENT = "INSERT INTO client(edrpou, email, phoneclient, authortask, internaltelauthor, id) VALUES(?, ?, ?, ?, ?, (SELECT max(id) from sotaform_db.task))";

    public ClientDaoImpl(Class type) {
        super(type);
    }

    public static synchronized ClientDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new ClientDaoImpl(Client.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Client entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Client entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getEdrpou());
        preparedStatement.setString(2, entity.getEmail());
        preparedStatement.setString(3, entity.getPhoneClient());
        preparedStatement.setString(4, entity.getAuthorTask());
        preparedStatement.setInt(5, entity.getInternaltelauthor());
        return preparedStatement;
    }

    @Override
    protected List<Client> readAll(ResultSet resultSet) throws SQLException {
        List<Client> result = new LinkedList<>();
        Client client = null;
        while (resultSet.next()) {
            client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setEdrpou(resultSet.getString("edrpou"));
            client.setEmail(resultSet.getString("email"));
            client.setPhoneClient(resultSet.getString("phoneclient"));
            client.setAuthorTask(resultSet.getString("authortask"));
            client.setInternaltelauthor(resultSet.getInt("internaltelauthor"));
            result.add(client);
        }
        return result;
    }

    @Override
    protected List<Client> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, Client entity) throws SQLException {
        return null;
    }

    @Override
    public Client getUserByInnerTell(Integer innerTell) {
        return null;
    }
}
