package dto;

import java.sql.Blob;

/**
 * Created by v_minjajlo on 24.11.2016.
 */
public class TaskDTO extends EntityDTO<Integer> {
    private String answer;
    private String textError;
    private String dateTask;
    private String description;
    private String subject;


    public TaskDTO() {
    }

    public TaskDTO(String dateTask, String description, String textError, String subject) {
        this.dateTask = dateTask;
        this.description = description;
        this.textError = textError;
        this.subject = subject;
    }


    public TaskDTO(String answer, Integer id) {
        this.setId(id);
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDateTask() {
        return dateTask;
    }

    public void setDateTask(String dateTask) {
        this.dateTask = dateTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTextError() {
        return textError;
    }

    public void setTextError(String textError) {
        this.textError = textError;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDTO)) return false;
        if (!super.equals(o)) return false;

        TaskDTO taskDTO = (TaskDTO) o;

        if (textError != null ? !textError.equals(taskDTO.textError) : taskDTO.textError != null) return false;
        if (dateTask != null ? !dateTask.equals(taskDTO.dateTask) : taskDTO.dateTask != null) return false;
        if (description != null ? !description.equals(taskDTO.description) : taskDTO.description != null) return false;
        if (subject != null ? !subject.equals(taskDTO.subject) : taskDTO.subject != null) return false;
        return answer != null ? answer.equals(taskDTO.answer) : taskDTO.answer == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (textError != null ? textError.hashCode() : 0);
        result = 31 * result + (dateTask != null ? dateTask.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "answer='" + answer + '\'' +
                ", textError='" + textError + '\'' +
                ", dateTask='" + dateTask + '\'' +
                ", description='" + description + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
