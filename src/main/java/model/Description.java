package model;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class Description extends Entity<Integer> {

    private String descriptionquest;
    private int task_id;
    private int transfer_id;

    public Description(){
    }
    public Description(String descriptionquest){
        this.descriptionquest = descriptionquest;
    }

    public Description(String descriptionquest, int task_id, int transfer_id) {
        this.descriptionquest = descriptionquest;
        this.task_id = task_id;
        this.transfer_id = transfer_id;
    }

    public String getDescriptionquest() {
        return descriptionquest;
    }

    public void setDescriptionquest(String descriptionquest) {
        this.descriptionquest = descriptionquest;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "Description{" +
                "descriptionquest='" + descriptionquest + '\'' +
                ", task_id=" + task_id +
                ", transfer_id=" + transfer_id +
                '}';
    }

}
