package service.impl;


import dao.DaoFactory;
import dao.api.Dao;
import dto.TaskDTO;
import mapper.BeanMapper;
import model.Task;
import service.api.Service;
import java.util.List;

public class TaskServiceImpl implements Service<Integer, TaskDTO> {

    private static TaskServiceImpl service;
    private Dao<Integer, Task> taskDao;
    private BeanMapper beanMapper;


    private TaskServiceImpl() {
        taskDao = DaoFactory.getInstance().getTaskDao();
        beanMapper = BeanMapper.getInstance();

}

public static synchronized TaskServiceImpl getInstance() {
        if (service == null) {
        service = new TaskServiceImpl();
        }
        return service;
        }

@Override
public List<TaskDTO> getAll() {
        List<Task> tasks = taskDao.getAll();
        List<TaskDTO> taskDTOs = beanMapper.listMapToList(tasks, TaskDTO.class);
        return taskDTOs;
        }

//    public List<TaskDTO> getByTitle(TaskDTO title) {
//        List<Task> movies = (List<Task>) new TaskDaoImpl().getInstance().getByTitle(title);
//        List<TaskDTO> movieDTOs = beanMapper.listMapToList(movies, TaskDTO.class);
//        return movieDTOs;
//    }

@Override
public void upload(TaskDTO taskDto) {
        Task task = beanMapper.singleMapper(taskDto, Task.class);
        taskDao.upload(task);
        }

@Override
public TaskDTO getById(Integer id) {
    Task task = taskDao.getById(id);
    TaskDTO taskDTO = beanMapper.singleMapper(task, TaskDTO.class);
        return taskDTO;
        }

    @Override
    public TaskDTO getUserByInnerTell(Integer innerTell) {
        return null;
    }

    @Override
    public List<TaskDTO> getListCommentById(Integer id) {
        return null;
    }

    @Override
public void delete(Integer key) {
        taskDao.delete(key);
        }

@Override
public void update(TaskDTO entity) {
    Task task = beanMapper.singleMapper(entity, Task.class);
    taskDao.update(task);
        }

    @Override
    public void InsertAnswer(TaskDTO entity) {
        Task task = beanMapper.singleMapper(entity, Task.class);
        taskDao.InsertAnswer(task);
    }

    @Override
    public TaskDTO getLastId() {
        Task taskId = taskDao.getLastId();
        TaskDTO taskDTO = beanMapper.singleMapper(taskId, TaskDTO.class);
        return taskDTO;
    }


}
