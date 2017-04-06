package model;

/**
 * Created by v_minjajlo on 08.02.2017.
 */
public class AnswerTask extends Entity<Integer> {

    private String comment;
    private String nameAuthor;
    private String time;

    public AnswerTask() {
    }

    public AnswerTask(String comment, String nameAuthor, String time) {
        this.comment = comment;
        this.time = time;
        this.nameAuthor = nameAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerTask)) return false;
        if (!super.equals(o)) return false;

        AnswerTask that = (AnswerTask) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (nameAuthor != null ? !nameAuthor.equals(that.nameAuthor) : that.nameAuthor != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (nameAuthor != null ? nameAuthor.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        return "AnswerTask{" +
                "comment='" + comment + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
