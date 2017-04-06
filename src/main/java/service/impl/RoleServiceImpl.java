package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.RoleDTO;
import mapper.BeanMapper;
import model.Role;
import service.api.Service;

import java.util.List;

public class RoleServiceImpl implements Service<Integer, RoleDTO> {

    private static RoleServiceImpl service;
    private Dao<Integer, Role> roleDao;
    private BeanMapper beanMapper;

    private RoleServiceImpl() {
        roleDao = DaoFactory.getInstance().getRoleDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized RoleServiceImpl getInstance() {
        if (service == null) {
            service = new RoleServiceImpl();
        }
        return service;
    }

    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = roleDao.getAll();
        List<RoleDTO> roleDTOs = beanMapper.listMapToList(roles, RoleDTO.class);
        return roleDTOs;
    }

    @Override
    public void upload(RoleDTO roleDTO) {
        Role role = beanMapper.singleMapper(roleDTO, Role.class);
        roleDao.upload(role);
    }

    @Override
    public RoleDTO getById(Integer id) {
        Role role = roleDao.getById(id);
        RoleDTO roleDTO = beanMapper.singleMapper(role, RoleDTO.class);
        return roleDTO;
    }

    @Override
    public RoleDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<RoleDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer key) {
        roleDao.delete(key);
    }

    @Override
    public void update(RoleDTO roleDTO) {
        Role role = beanMapper.singleMapper(roleDTO, Role.class);
        roleDao.update(role);
    }

    @Override
    public void InsertAnswer(RoleDTO entity) {

    }

    @Override
    public RoleDTO getLastId() {
        return null;
    }

}
