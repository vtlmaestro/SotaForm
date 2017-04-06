package model;

import java.sql.Blob;

/**
 * Created by v_minjajlo on 24.11.2016.
 */
public class Task extends Entity<Integer> {
    private String answer;
    private String textError;
    private String dateTask;
    private String description;
    private String subject;


    public Task() {
    }

    public Task(String dateTask, String description, String textError, String subject) {
        this.dateTask = dateTask;
        this.description = description;
        this.textError = textError;
        this.subject = subject;
    }

    public Task(String answer, Integer id) {
        this.setId(id);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        if (!super.equals(o)) return false;

        Task task = (Task) o;

        if (textError != null ? !textError.equals(task.textError) : task.textError != null) return false;
        if (dateTask != null ? !dateTask.equals(task.dateTask) : task.dateTask != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (subject != null ? !subject.equals(task.subject) : task.subject != null) return false;
        return answer != null ? answer.equals(task.answer) : task.answer == null;

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
        return "Task{" +
                "answer='" + answer + '\'' +
                ", textError='" + textError + '\'' +
                ", dateTask='" + dateTask + '\'' +
                ", description='" + description + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}


