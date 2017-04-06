package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.EmailDTO;
import mapper.BeanMapper;
import model.Email;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 14.11.2016.
 */
public class EmailServaceImpl implements Service<Integer, EmailDTO> {

    private static EmailServaceImpl service;
    private Dao<Integer, Email> emailDao;
    private BeanMapper beanMapper;

    private EmailServaceImpl() {
        emailDao = DaoFactory.getInstance().getEmailDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized EmailServaceImpl getInstance() {
        if (service == null) {
            service = new EmailServaceImpl();
        }
        return service;
    }


    @Override
    public List<EmailDTO> getAll() {
        return null;
    }

    @Override
    public EmailDTO getById(Integer id) {
        return null;
    }

    @Override
    public EmailDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<EmailDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(EmailDTO emailDTO) {
        Email email = beanMapper.singleMapper(emailDTO, Email.class);
        emailDao.upload(email);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(EmailDTO entity) {

    }

    @Override
    public void InsertAnswer(EmailDTO entity) {

    }

    @Override
    public EmailDTO getLastId() {
        return null;
    }
}
