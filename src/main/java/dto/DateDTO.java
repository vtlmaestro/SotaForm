package dto;

import java.time.LocalDate;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class DateDTO extends EntityDTO<Integer>{

    private LocalDate datequestDTO;
    private int task_idDTO;
    private int transfer_idDTO;

    public DateDTO(){
    }

    public DateDTO(LocalDate datequestDTO, int task_idDTO, int transfer_idDTO) {
        this.datequestDTO = datequestDTO;
        this.task_idDTO = task_idDTO;
        this.transfer_idDTO = transfer_idDTO;
    }

    public LocalDate getDatequestDTO() {
        return datequestDTO;
    }

    public void setDatequestDTO(LocalDate datequestDTO) {
        this.datequestDTO = datequestDTO;
    }

    public int getTask_idDTO() {
        return task_idDTO;
    }

    public void setTask_idDTO(int task_idDTO) {
        this.task_idDTO = task_idDTO;
    }

    public int getTransfer_idDTO() {
        return transfer_idDTO;
    }

    public void setTransfer_idDTO(int transfer_idDTO) {
        this.transfer_idDTO = transfer_idDTO;
    }

    @Override
    public String toString() {
        return "DateDTO{" +
                "datequestDTO=" + datequestDTO +
                ", task_idDTO=" + task_idDTO +
                ", transfer_idDTO=" + transfer_idDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DateDTO dateDTO = (DateDTO) o;

        if (task_idDTO != dateDTO.task_idDTO) return false;
        if (transfer_idDTO != dateDTO.transfer_idDTO) return false;
        return datequestDTO != null ? datequestDTO.equals(dateDTO.datequestDTO) : dateDTO.datequestDTO == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (datequestDTO != null ? datequestDTO.hashCode() : 0);
        result = 31 * result + task_idDTO;
        result = 31 * result + transfer_idDTO;
        return result;
    }
}
