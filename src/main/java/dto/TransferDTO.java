package dto;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class TransferDTO extends EntityDTO<Integer>{

    private String oldaccount;
    private String newaccount;

    public TransferDTO(){
    }

    public TransferDTO(String newaccount) {
        this.newaccount = newaccount;
    }

    public TransferDTO(String newaccount, String oldaccount) {
        this.newaccount = newaccount;
        this.oldaccount = oldaccount;
    }


    public String getNewaccount() {
        return newaccount;
    }

    public void setNewaccount(String newaccount) {
        this.newaccount = newaccount;
    }

    public String getOldaccount() {
        return oldaccount;
    }

    public void setOldaccount(String oldaccount) {
        this.oldaccount = oldaccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferDTO)) return false;
        if (!super.equals(o)) return false;

        TransferDTO that = (TransferDTO) o;

        if (oldaccount != null ? !oldaccount.equals(that.oldaccount) : that.oldaccount != null) return false;
        return newaccount != null ? newaccount.equals(that.newaccount) : that.newaccount == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (oldaccount != null ? oldaccount.hashCode() : 0);
        result = 31 * result + (newaccount != null ? newaccount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransferDTO{" +
                "newaccount='" + newaccount + '\'' +
                ", oldaccount='" + oldaccount + '\'' +
                '}';
    }
}
