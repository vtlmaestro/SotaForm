package dao.impl;

import dao.api.Dao;
import model.ContentDownloads;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class ContentDownloadsDAOImpl extends CrudDAO<ContentDownloads> {

    public ContentDownloadsDAOImpl(Class type) {
        super(type);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, ContentDownloads entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, ContentDownloads entity) throws SQLException {
        return null;
    }

    @Override
    protected List<ContentDownloads> readAll(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected List<ContentDownloads> readListAllComment(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected int getLastInsertId(ResultSet resultSet) throws SQLException {
        return Integer.parseInt(null);
    }

    @Override
    public PreparedStatement InsertAnsw(Connection connection, ContentDownloads entity) throws SQLException {
        return null;
    }

    @Override
    public ContentDownloads getUserByInnerTell(Integer innerTell) {
        return null;
    }
}
