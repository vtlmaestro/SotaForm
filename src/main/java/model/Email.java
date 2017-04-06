package model;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class Email extends Entity<Integer> {

    private String emailclient;
    private int task_id;
    private int tranfer_id;

    public Email(){
    }

    public Email(String emailclient){
        this.emailclient = emailclient;
    }

    public Email(String emailclient, int tranfer_id, int task_id) {
        this.emailclient = emailclient;
        this.tranfer_id = tranfer_id;
        this.task_id = task_id;
    }

    public String getEmailclient() {
        return emailclient;
    }

    public void setEmailclient(String emailclient) {
        this.emailclient = emailclient;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getTranfer_id() {
        return tranfer_id;
    }

    public void setTranfer_id(int tranfer_id) {
        this.tranfer_id = tranfer_id;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailclient='" + emailclient + '\'' +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }

}
