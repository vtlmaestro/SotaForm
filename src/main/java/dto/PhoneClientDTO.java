package dto;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class PhoneClientDTO extends EntityDTO<Integer> {

    private int phone;
    private int task_id;
    private int tranfer_id;

    public PhoneClientDTO(){
    }

    public PhoneClientDTO(int phone){
        this.phone = phone;
    }
    public PhoneClientDTO(int phone, int task_id, int tranfer_id) {
        this.phone = phone;
        this.task_id = task_id;
        this.tranfer_id = tranfer_id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
        return "PhoneClientDTO{" +
                "phone=" + phone +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }

}
