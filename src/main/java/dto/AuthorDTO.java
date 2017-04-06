package dto;

import model.Entity;

/**
 * Created by v_minjajlo on 25.11.2016.
 */
public class AuthorDTO extends Entity<Integer> {
    private String authorNamequest;
    private int internaltelaut;
    private int task_id;
    private int transfer_id;

    public AuthorDTO() {
    }

    public AuthorDTO(String authorNamequest, int internaltelaut, int task_id, int transfer_id) {
        this.authorNamequest = authorNamequest;
        this.internaltelaut = internaltelaut;
        this.task_id = task_id;
        this.transfer_id = transfer_id;
    }

    public String getAuthorNamequest() {
        return authorNamequest;
    }

    public void setAuthorNamequest(String authorNamequest) {
        this.authorNamequest = authorNamequest;
    }

    public int getInternaltelaut() {
        return internaltelaut;
    }

    public void setInternaltelaut(int internaltelaut) {
        this.internaltelaut = internaltelaut;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDTO)) return false;
        if (!super.equals(o)) return false;

        AuthorDTO authorDTO = (AuthorDTO) o;

        if (internaltelaut != authorDTO.internaltelaut) return false;
        if (task_id != authorDTO.task_id) return false;
        if (transfer_id != authorDTO.transfer_id) return false;
        return authorNamequest != null ? authorNamequest.equals(authorDTO.authorNamequest) : authorDTO.authorNamequest == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (authorNamequest != null ? authorNamequest.hashCode() : 0);
        result = 31 * result + internaltelaut;
        result = 31 * result + task_id;
        result = 31 * result + transfer_id;
        return result;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "authorNamequest='" + authorNamequest + '\'' +
                ", internaltelaut=" + internaltelaut +
                ", task_id=" + task_id +
                ", transfer_id=" + transfer_id +
                '}';
    }
}
