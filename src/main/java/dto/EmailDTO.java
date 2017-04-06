package dto;

/**
 * Created by v_minjajlo on 25.11.2016.
 */
public class EmailDTO {
    private String emailclient;
    private int task_id;
    private int tranfer_id;

    public EmailDTO() {
    }

    public EmailDTO(String emailclient, int task_id, int tranfer_id) {
        this.emailclient = emailclient;
        this.task_id = task_id;
        this.tranfer_id = tranfer_id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailDTO)) return false;

        EmailDTO emailDTO = (EmailDTO) o;

        if (task_id != emailDTO.task_id) return false;
        if (tranfer_id != emailDTO.tranfer_id) return false;
        return emailclient != null ? emailclient.equals(emailDTO.emailclient) : emailDTO.emailclient == null;

    }

    @Override
    public int hashCode() {
        int result = emailclient != null ? emailclient.hashCode() : 0;
        result = 31 * result + task_id;
        result = 31 * result + tranfer_id;
        return result;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "emailclient='" + emailclient + '\'' +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }
}
