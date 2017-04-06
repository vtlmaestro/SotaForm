package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.AnswerTaskDTO;
import mapper.BeanMapper;
import model.AnswerTask;
import service.api.Service;
import java.util.List;

/**
 * Created by v_minjajlo on 08.02.2017.
 */
public class AnswerTaskServiceImpl implements Service<Integer, AnswerTaskDTO> {
    private static AnswerTaskServiceImpl service;
    private Dao<Integer, AnswerTask> answerTaskDao;
    private BeanMapper beanMapper;

    private AnswerTaskServiceImpl() {
        answerTaskDao = DaoFactory.getInstance().getAnswerTaskDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized AnswerTaskServiceImpl getInstance() {
        if (service == null) {
            service = new AnswerTaskServiceImpl();
        }
        return service;
    }

    @Override
    public List<AnswerTaskDTO> getAll() {
        return null;
    }

    @Override
    public AnswerTaskDTO getById(Integer id) {
        AnswerTask answerTask = answerTaskDao.getById(id);
        AnswerTaskDTO answerTaskDTO = beanMapper.singleMapper(answerTask, AnswerTaskDTO.class);
        return answerTaskDTO;
    }

    @Override
    public AnswerTaskDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<AnswerTaskDTO> getListCommentById(Integer id) {
        List<AnswerTask> answerTasks = answerTaskDao.getListCommentById(id);
        List<AnswerTaskDTO> answerTaskDTO = beanMapper.listMapToList(answerTasks, AnswerTaskDTO.class);
        return answerTaskDTO;
    }

    @Override
    public void upload(AnswerTaskDTO entity) {

    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(AnswerTaskDTO entity) {

    }

    @Override
    public void InsertAnswer(AnswerTaskDTO AnswerTaskDTO) {
        AnswerTask answerTask = beanMapper.singleMapper(AnswerTaskDTO, AnswerTask.class);
        answerTaskDao.InsertAnswer(answerTask);
    }

    @Override
    public AnswerTaskDTO getLastId() {
        return null;
    }
}
