package model;

/**
 * Created by v_minjajlo on 25.11.2016.
 */
public class Author extends Entity<Integer> {
    private String authorNamequest;
    private int internaltelaut;
    private int task_id;
    private int transfer_id;

    public Author() {
    }

    public Author(String authorNamequest, int transfer_id, int task_id, int internaltelaut) {
        this.authorNamequest = authorNamequest;
        this.transfer_id = transfer_id;
        this.task_id = task_id;
        this.internaltelaut = internaltelaut;
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
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (internaltelaut != author.internaltelaut) return false;
        if (task_id != author.task_id) return false;
        if (transfer_id != author.transfer_id) return false;
        return authorNamequest != null ? authorNamequest.equals(author.authorNamequest) : author.authorNamequest == null;

    }

    @Override
    public int hashCode() {
        int result = authorNamequest != null ? authorNamequest.hashCode() : 0;
        result = 31 * result + internaltelaut;
        result = 31 * result + task_id;
        result = 31 * result + transfer_id;
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorNamequest='" + authorNamequest + '\'' +
                ", internaltelaut=" + internaltelaut +
                ", task_id=" + task_id +
                ", transfer_id=" + transfer_id +
                '}';
    }
}
