package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.EdrpouDTO;
import mapper.BeanMapper;
import model.Edrpou;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 14.11.2016.
 */
public class EdrpouServiseImpl implements Service<Integer, EdrpouDTO> {

    private static EdrpouServiseImpl service;
    private Dao<Integer, Edrpou> edrpouDao;
    private BeanMapper beanMapper;

    private EdrpouServiseImpl() {
        edrpouDao = DaoFactory.getInstance().getEdrpouDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized EdrpouServiseImpl getInstance() {
        if (service == null) {
            service = new EdrpouServiseImpl();
        }
        return service;
    }

    @Override
    public List<EdrpouDTO> getAll() {
        return null;
    }

    @Override
    public EdrpouDTO getById(Integer id) {
        return null;
    }

    @Override
    public EdrpouDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<EdrpouDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(EdrpouDTO edrpouDTO) {
        Edrpou edrpou = beanMapper.singleMapper(edrpouDTO, Edrpou.class);
        edrpouDao.upload(edrpou);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(EdrpouDTO entity) {

    }

    @Override
    public void InsertAnswer(EdrpouDTO entity) {

    }

    @Override
    public EdrpouDTO getLastId() {
        return null;
    }
}
