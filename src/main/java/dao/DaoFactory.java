package dao;

import dao.api.Dao;
import dao.impl.*;
import helpers.PropertyHolder;
import model.*;

public class DaoFactory {

    private static DaoFactory instance = null;
    private Dao<Integer, Role> roleDao;
    private Dao<Integer, User> userDao;
    private Dao<Integer, Author> authorDao;
    private Dao<Integer, Edrpou> edrpouDao;
    private Dao<Integer, Email> emailDao;
    private Dao<Integer, PhoneClient> phoneClientDao;
    private Dao<Integer, Task> taskDao;
    private Dao<Integer, Description> descriptionDao;
    private Dao<Integer, Client> clientDao;
    private Dao<Integer, AnswerTask> answerTaskDao;
    private Dao<Integer, Transfer> transferDao;

    private DaoFactory(){
        loadDaos();
    }

    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDaos() {
       if(PropertyHolder.getInstance().isInMemoryDB()){

       }else{

           userDao = new UserDaoImpl(User.class);
           roleDao = new RoleDaoImpl(Role.class);
           authorDao = new AuthorDaoImpl(Author.class);
           edrpouDao = new EdrpouDAOImpl(Edrpou.class);
           emailDao = new EmailDAOImpl(Email.class);
           phoneClientDao = new PhoneClientDAOImp(PhoneClient.class);
           taskDao = new TaskDaoImpl(Task.class);
           descriptionDao = new DescriptionDaoImpl(Description.class);
           clientDao = new ClientDaoImpl(Client.class);
           answerTaskDao = new AnswerDaoImpl(AnswerTask.class);
           transferDao = new TransferDAOImpl(Transfer.class);
       }
    }

    public Dao<Integer, Transfer> getTransferDao() {
        return transferDao;
    }

    public void setTransferDao(Dao<Integer, Transfer> transferDao) {
        this.transferDao = transferDao;
    }

    public Dao<Integer, AnswerTask> getAnswerTaskDao() {
        return answerTaskDao;
    }

    public void setAnswerTaskDao(Dao<Integer, AnswerTask> answerTaskDao) {
        this.answerTaskDao = answerTaskDao;
    }

    public Dao<Integer, Description> getDescriptionDao() {
        return descriptionDao;
    }

    public Dao<Integer, Client> getClientDao() {
        return clientDao;
    }

    public void setClientDao(Dao<Integer, Client> clientDao) {
        this.clientDao = clientDao;
    }

    public void setDescriptionDao(Dao<Integer, Description> descriptionDao) {
        this.descriptionDao = descriptionDao;
    }

    public Dao<Integer, PhoneClient> getPhoneClientDao() {
        return phoneClientDao;
    }

    public void setPhoneClientDao(Dao<Integer, PhoneClient> phoneClientDao) {
        this.phoneClientDao = phoneClientDao;
    }

    public Dao<Integer, Email> getEmailDao() {
        return emailDao;
    }

    public void setEmailDao(Dao<Integer, Email> emailDao) {
        this.emailDao = emailDao;
    }

    public Dao<Integer, Edrpou> getEdrpouDao() {
        return edrpouDao;
    }

    public void setEdrpouDao(Dao<Integer, Edrpou> edrpouDao) {
        this.edrpouDao = edrpouDao;
    }

    public Dao<Integer, Author> getAuthorDao() {
        return authorDao;
    }

    public void setAuthorDao(Dao<Integer, Author> authorDao) {
        this.authorDao = authorDao;
    }

    public Dao<Integer, Task> getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(Dao<Integer, Task> taskDao) {
        this.taskDao = taskDao;
    }

    public static void setInstance(DaoFactory instance) {
        DaoFactory.instance = instance;
    }

    public Dao<Integer, Role> getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(Dao<Integer, Role> roleDao) {
        this.roleDao = roleDao;
    }

    public Dao<Integer, User> getUserDao() {
        return userDao;
    }

    public void setUserDao(Dao<Integer, User> userDao) {
        this.userDao = userDao;
    }

}
