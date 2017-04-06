package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.PhoneClientDTO;
import mapper.BeanMapper;
import model.PhoneClient;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 14.11.2016.
 */
public class PhoneClientServaceImpl implements Service<Integer, PhoneClientDTO> {

    private static PhoneClientServaceImpl service;
    private Dao<Integer, PhoneClient> phoneClientDao;
    private BeanMapper beanMapper;

    private PhoneClientServaceImpl() {
        phoneClientDao = DaoFactory.getInstance().getPhoneClientDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized PhoneClientServaceImpl getInstance() {
        if (service == null) {
            service = new PhoneClientServaceImpl();
        }
        return service;
    }

    @Override
    public List<PhoneClientDTO> getAll() {
        return null;
    }

    @Override
    public PhoneClientDTO getById(Integer id) {
        return null;
    }

    @Override
    public PhoneClientDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<PhoneClientDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(PhoneClientDTO phoneClientDTO) {
        PhoneClient phoneClient = beanMapper.singleMapper(phoneClientDTO, PhoneClient.class);
        phoneClientDao.upload(phoneClient);
    }


    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(PhoneClientDTO entity) {

    }

    @Override
    public void InsertAnswer(PhoneClientDTO entity) {

    }

    @Override
    public PhoneClientDTO getLastId() {
        return null;
    }

}
