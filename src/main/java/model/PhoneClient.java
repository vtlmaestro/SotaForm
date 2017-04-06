package model;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class PhoneClient extends Entity<Integer> {

    private int phone;
    private int task_id;
    private int tranfer_id;

    public PhoneClient(){
    }

    public PhoneClient(int phone){
        this.phone = phone;
    }

    public PhoneClient(int phone, int task_id, int tranfer_id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneClient)) return false;
        if (!super.equals(o)) return false;

        PhoneClient that = (PhoneClient) o;

        if (phone != that.phone) return false;
        if (task_id != that.task_id) return false;
        return tranfer_id == that.tranfer_id;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + phone;
        result = 31 * result + task_id;
        result = 31 * result + tranfer_id;
        return result;
    }

    @Override
    public String toString() {
        return "PhoneClient{" +
                "phone=" + phone +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }

}
