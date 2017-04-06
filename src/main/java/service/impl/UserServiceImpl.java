package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.UserDTO;
import mapper.BeanMapper;
import model.User;
import service.api.Service;

import java.util.List;


public class UserServiceImpl implements Service<Integer, UserDTO> {

    private static UserServiceImpl service;
    private Dao<Integer, User> userDao;
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userDao.getById(id);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO getUserByInnerTell(Integer innerTell) {
        User user = userDao.getUserByInnerTell(innerTell);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(UserDTO userDTO) {
        User user = beanMapper.singleMapper(userDTO, User.class);
        userDao.upload(user);
    }

    public UserDTO getByLogin(String value){
        User user = userDao.getBy("login", value);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void delete(Integer key) {
        userDao.delete(key);
    }

    @Override
    public void update(UserDTO entity) {
        User user = beanMapper.singleMapper(entity, User.class);
        userDao.update(user);
    }

    @Override
    public void InsertAnswer(UserDTO entity) {

    }

    @Override
    public UserDTO getLastId() {
        return null;
    }


}
