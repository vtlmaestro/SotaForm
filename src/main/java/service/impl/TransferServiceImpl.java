package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.TransferDTO;
import mapper.BeanMapper;
import model.Transfer;
import service.api.Service;

import java.util.List;

/**
 * Created by v_minjajlo on 21.02.2017.
 */
public class TransferServiceImpl implements Service<Integer, TransferDTO> {

    private static TransferServiceImpl service;
    private Dao<Integer, Transfer> transferDao;
    private BeanMapper beanMapper;

    private TransferServiceImpl() {
        transferDao = DaoFactory.getInstance().getTransferDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized TransferServiceImpl getInstance() {
        if (service == null) {
            service = new TransferServiceImpl();
        }
        return service;
    }

    @Override
    public List<TransferDTO> getAll() {
        List<Transfer> transfers = transferDao.getAll();
        List<TransferDTO> transferDTOs = beanMapper.listMapToList(transfers, TransferDTO.class);
        return transferDTOs;
    }

    @Override
    public TransferDTO getById(Integer id) {
        Transfer transfer = transferDao.getById(id);
        TransferDTO transferDTO = beanMapper.singleMapper(transfer, TransferDTO.class);
        return transferDTO;
    }

    @Override
    public TransferDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<TransferDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
    public void upload(TransferDTO transferDTO) {
        Transfer transfer = beanMapper.singleMapper(transferDTO, Transfer.class);
        transferDao.upload(transfer);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(TransferDTO entity) {
        Transfer transfer = beanMapper.singleMapper(entity, Transfer.class);
        transferDao.update(transfer);
    }

    @Override
    public void InsertAnswer(TransferDTO entity) {

    }

    @Override
    public TransferDTO getLastId() {
        return null;
    }
}
