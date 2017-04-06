package dto;

/**
 * Created by v_minjajlo on 08.02.2017.
 */
public class AnswerTaskDTO extends EntityDTO<Integer>{

    private String comment;
    private String nameAuthor;
    private String time;

    public AnswerTaskDTO() {
    }

    public AnswerTaskDTO(String comment, String nameAuthor, String time) {
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
        if (!(o instanceof AnswerTaskDTO)) return false;
        if (!super.equals(o)) return false;

        AnswerTaskDTO that = (AnswerTaskDTO) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return nameAuthor != null ? nameAuthor.equals(that.nameAuthor) : that.nameAuthor == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (nameAuthor != null ? nameAuthor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnswerTaskDTO{" +
                "comment='" + comment + '\'' +
                ", time='" + time + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                '}';
    }
}
