package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.AuthorDTO;
import mapper.BeanMapper;
import model.Author;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 08.11.2016.
 */
public class AuthorServiceImpl implements Service<Integer, AuthorDTO> {
    @Override
    public void InsertAnswer(AuthorDTO entity) {

    }

    private static AuthorServiceImpl service;
    private Dao<Integer, Author> authorDao;
    private BeanMapper beanMapper;

    private AuthorServiceImpl() {
        authorDao = DaoFactory.getInstance().getAuthorDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized AuthorServiceImpl getInstance() {
        if (service == null) {
            service = new AuthorServiceImpl();
        }
        return service;
    }

    @Override
    public List<AuthorDTO> getAll() {
        return null;
    }

    @Override
    public AuthorDTO getById(Integer id) {
        return null;
    }

    @Override
    public AuthorDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<AuthorDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(AuthorDTO authorDTO) {
        Author author = beanMapper.singleMapper(authorDTO, Author.class);
        authorDao.upload(author);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(AuthorDTO entity) {

    }

    @Override
    public AuthorDTO getLastId() {
        return null;
    }
}
