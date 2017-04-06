package model;

import java.time.LocalDate;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class Date extends Entity<Integer> {
    private LocalDate datequest;
    private int task_id;
    private int transfer_id;

    public Date(){
    }

    public Date(LocalDate datequest, int task_id, int transfer_id) {
        this.datequest = datequest;
        this.task_id = task_id;
        this.transfer_id = transfer_id;
    }

    public LocalDate getDatequest() {
        return datequest;
    }

    public void setDatequest(LocalDate datequest) {
        this.datequest = datequest;
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
        return "Date{" +
                "datequest=" + datequest +
                ", task_id=" + task_id +
                ", transfer_id=" + transfer_id +
                '}';
    }

}
