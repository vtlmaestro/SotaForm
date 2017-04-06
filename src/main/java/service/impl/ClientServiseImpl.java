package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.ClientDTO;
import mapper.BeanMapper;
import model.Client;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 14.12.2016.
 */
public class ClientServiseImpl implements Service<Integer, ClientDTO> {
    private static ClientServiseImpl service;
    private Dao<Integer, Client> clientDao;
    private BeanMapper beanMapper;

    private ClientServiseImpl() {
        clientDao = DaoFactory.getInstance().getClientDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized ClientServiseImpl getInstance() {
        if (service == null) {
            service = new ClientServiseImpl();
        }
        return service;
    }


    @Override
    public List<ClientDTO> getAll() {
        return null;
    }

    @Override
    public ClientDTO getById(Integer id){
    Client client = clientDao.getById(id);
    ClientDTO taskDTO = beanMapper.singleMapper(client, ClientDTO.class);
    return taskDTO;
}

    @Override
    public ClientDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<ClientDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(ClientDTO clientDTO) {
        Client client = beanMapper.singleMapper(clientDTO, Client.class);
        clientDao.upload(client);

    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(ClientDTO entity) {

    }

    @Override
    public void InsertAnswer(ClientDTO entity) {

    }

    @Override
    public ClientDTO getLastId() {
        return null;
    }
}
