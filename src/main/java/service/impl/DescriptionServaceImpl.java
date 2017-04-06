package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.DescriptionDTO;
import mapper.BeanMapper;
import model.Description;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 14.11.2016.
 */
public class DescriptionServaceImpl implements Service<Integer, DescriptionDTO> {

    private static DescriptionServaceImpl service;
    private Dao<Integer, Description> descriptionDao;
    private BeanMapper beanMapper;

    private DescriptionServaceImpl() {
        descriptionDao = DaoFactory.getInstance().getDescriptionDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized DescriptionServaceImpl getInstance() {
        if (service == null) {
            service = new DescriptionServaceImpl();
        }
        return service;
    }

    @Override
    public List<DescriptionDTO> getAll() {
        return null;
    }

    @Override
    public DescriptionDTO getById(Integer id) {
        return null;
    }

    @Override
    public DescriptionDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<DescriptionDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(DescriptionDTO descriptionDTO) {
        Description description = beanMapper.singleMapper(descriptionDTO, Description.class);
        descriptionDao.upload(description);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(DescriptionDTO entity) {

    }

    @Override
    public void InsertAnswer(DescriptionDTO entity) {

    }

    @Override
    public DescriptionDTO getLastId() {
        return null;
    }
}
