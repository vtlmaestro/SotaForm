package dto;

/**
 * Created by v_minjajlo on 14.12.2016.
 */
public class ClientDTO extends EntityDTO<Integer> {
    private String edrpou;
    private String email;
    private String phoneClient;
    private String authorTask;
    private int  internaltelauthor;
    private int taskId;

    public ClientDTO(){
    }

    public ClientDTO(String authorTask, String phoneClient, int internaltelauthor, String email, String edrpou) {
        this.authorTask = authorTask;
        this.phoneClient = phoneClient;
        this.internaltelauthor = internaltelauthor;
        this.email = email;
        this.edrpou = edrpou;
    }

    public String getAuthorTask() {
        return authorTask;
    }

    public void setAuthorTask(String authorTask) {
        this.authorTask = authorTask;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public int getInternaltelauthor() {
        return internaltelauthor;
    }

    public void setInternaltelauthor(int internaltelauthor) {
        this.internaltelauthor = internaltelauthor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientDTO)) return false;
        if (!super.equals(o)) return false;

        ClientDTO clientDTO = (ClientDTO) o;

        if (internaltelauthor != clientDTO.internaltelauthor) return false;
        if (taskId != clientDTO.taskId) return false;
        if (edrpou != null ? !edrpou.equals(clientDTO.edrpou) : clientDTO.edrpou != null) return false;
        if (email != null ? !email.equals(clientDTO.email) : clientDTO.email != null) return false;
        if (phoneClient != null ? !phoneClient.equals(clientDTO.phoneClient) : clientDTO.phoneClient != null)
            return false;
        return authorTask != null ? authorTask.equals(clientDTO.authorTask) : clientDTO.authorTask == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (edrpou != null ? edrpou.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneClient != null ? phoneClient.hashCode() : 0);
        result = 31 * result + (authorTask != null ? authorTask.hashCode() : 0);
        result = 31 * result + internaltelauthor;
        result = 31 * result + taskId;
        return result;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "authorTask='" + authorTask + '\'' +
                ", edrpou='" + edrpou + '\'' +
                ", email='" + email + '\'' +
                ", phoneClient='" + phoneClient + '\'' +
                ", internaltelauthor=" + internaltelauthor +
                ", taskId=" + taskId +
                '}';
    }
}
