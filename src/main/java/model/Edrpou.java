package model;

/**
 * Created by v_minjajlo on 24.11.2016.
 */
public class Edrpou extends Entity<Integer> {
    private int edrpou;
    private int task_id;
    private int tranfer_id;

    public Edrpou() {
    }

    public Edrpou(int edrpou, int task_id, int tranfer_id) {
        this.edrpou = edrpou;
        this.task_id = task_id;
        this.tranfer_id = tranfer_id;
    }

    public int getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(int edrpou) {
        this.edrpou = edrpou;
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
        if (!(o instanceof Edrpou)) return false;

        Edrpou edrpou = (Edrpou) o;

        if (this.edrpou != edrpou.edrpou) return false;
        if (task_id != edrpou.task_id) return false;
        return tranfer_id == edrpou.tranfer_id;

    }

    @Override
    public int hashCode() {
        int result = edrpou;
        result = 31 * result + task_id;
        result = 31 * result + tranfer_id;
        return result;
    }

    @Override
    public String toString() {
        return "Edrpou{" +
                "edrpou=" + edrpou +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }
}
