package model;


/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class Transfer extends Entity<Integer> {

    private String oldaccount;
    private String newaccount;

    public Transfer(){
    }

    public Transfer(String newaccount) {
        this.newaccount = newaccount;
    }

    public Transfer(String newaccount, String oldaccount) {
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
        if (!(o instanceof Transfer)) return false;
        if (!super.equals(o)) return false;

        Transfer transfer = (Transfer) o;

        if (oldaccount != null ? !oldaccount.equals(transfer.oldaccount) : transfer.oldaccount != null) return false;
        return newaccount != null ? newaccount.equals(transfer.newaccount) : transfer.newaccount == null;

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
        return "Transfer{" +
                "newaccount='" + newaccount + '\'' +
                ", oldaccount='" + oldaccount + '\'' +
                '}';
    }
}
