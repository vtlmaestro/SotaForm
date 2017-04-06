package dto;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class ContentDownloadDTO extends EntityDTO<Integer> {

    private String nameContent;
    private int cont_task_idDTO;
    private int cont_tranfer_idDTO;
    private int task_idDTO;
    private  int tranfer_idDTO;

    ContentDownloadDTO(){
    }

    public ContentDownloadDTO(String nameContent, int cont_task_idDTO, int cont_tranfer_idDTO, int task_idDTO, int tranfer_idDTO) {
        this.nameContent = nameContent;
        this.cont_task_idDTO = cont_task_idDTO;
        this.cont_tranfer_idDTO = cont_tranfer_idDTO;
        this.task_idDTO = task_idDTO;
        this.tranfer_idDTO = tranfer_idDTO;
    }

    public String getNameContent() {
        return nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public int getCont_task_idDTO() {
        return cont_task_idDTO;
    }

    public void setCont_task_idDTO(int cont_task_idDTO) {
        this.cont_task_idDTO = cont_task_idDTO;
    }

    public int getCont_tranfer_idDTO() {
        return cont_tranfer_idDTO;
    }

    public void setCont_tranfer_idDTO(int cont_tranfer_idDTO) {
        this.cont_tranfer_idDTO = cont_tranfer_idDTO;
    }

    public int getTask_idDTO() {
        return task_idDTO;
    }

    public void setTask_idDTO(int task_idDTO) {
        this.task_idDTO = task_idDTO;
    }

    public int getTranfer_idDTO() {
        return tranfer_idDTO;
    }

    public void setTranfer_idDTO(int tranfer_idDTO) {
        this.tranfer_idDTO = tranfer_idDTO;
    }

    @Override
    public String toString() {
        return "ContentDownloadDTO{" +
                "nameContent='" + nameContent + '\'' +
                ", cont_task_idDTO=" + cont_task_idDTO +
                ", cont_tranfer_idDTO=" + cont_tranfer_idDTO +
                ", task_idDTO=" + task_idDTO +
                ", tranfer_idDTO=" + tranfer_idDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentDownloadDTO that = (ContentDownloadDTO) o;

        if (cont_task_idDTO != that.cont_task_idDTO) return false;
        if (cont_tranfer_idDTO != that.cont_tranfer_idDTO) return false;
        if (task_idDTO != that.task_idDTO) return false;
        if (tranfer_idDTO != that.tranfer_idDTO) return false;
        return nameContent != null ? nameContent.equals(that.nameContent) : that.nameContent == null;

    }

    @Override
    public int hashCode() {
        int result = nameContent != null ? nameContent.hashCode() : 0;
        result = 31 * result + cont_task_idDTO;
        result = 31 * result + cont_tranfer_idDTO;
        result = 31 * result + task_idDTO;
        result = 31 * result + tranfer_idDTO;
        return result;
    }
}
