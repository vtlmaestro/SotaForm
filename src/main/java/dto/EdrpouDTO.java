package dto;

import model.Entity;

/**
 * Created by v_minjajlo on 24.11.2016.
 */
public class EdrpouDTO extends EntityDTO<Integer> {
    private int edrpou;
    private int task_id;
    private int tranfer_id;

    public EdrpouDTO() {
    }

    public EdrpouDTO(int edrpou, int task_id, int tranfer_id) {
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
        if (!(o instanceof EdrpouDTO)) return false;

        EdrpouDTO edrpouDTO = (EdrpouDTO) o;

        if (edrpou != edrpouDTO.edrpou) return false;
        if (task_id != edrpouDTO.task_id) return false;
        return tranfer_id == edrpouDTO.tranfer_id;

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
        return "EdrpouDTO{" +
                "edrpou=" + edrpou +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }
}
