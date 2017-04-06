package model;

/**
 * Created by v_minjajlo on 11.11.2016.
 */
public class ContentDownloads extends Entity<Integer> {

    private String nameContent;
    private int cont_task_id;
    private int cont_tranfer_id;
    private int task_id;
    private  int tranfer_id;

    public ContentDownloads(){
    }
    public ContentDownloads(String nameContent){
        this.nameContent = nameContent;
    }

    public ContentDownloads(String nameContent, int cont_task_id, int cont_tranfer_id, int task_id, int tranfer_id) {
        this.nameContent = nameContent;
        this.cont_task_id = cont_task_id;
        this.cont_tranfer_id = cont_tranfer_id;
        this.task_id = task_id;
        this.tranfer_id = tranfer_id;
    }

    public String getNameContent() {
        return nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public int getCont_task_id() {
        return cont_task_id;
    }

    public void setCont_task_id(int cont_task_id) {
        this.cont_task_id = cont_task_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getCont_tranfer_id() {
        return cont_tranfer_id;
    }

    public void setCont_tranfer_id(int cont_tranfer_id) {
        this.cont_tranfer_id = cont_tranfer_id;
    }

    public int getTranfer_id() {
        return tranfer_id;
    }

    public void setTranfer_id(int tranfer_id) {
        this.tranfer_id = tranfer_id;
    }

    @Override
    public String toString() {
        return "ContentDownloads{" +
                "nameContent='" + nameContent + '\'' +
                ", cont_task_id=" + cont_task_id +
                ", cont_tranfer_id=" + cont_tranfer_id +
                ", task_id=" + task_id +
                ", tranfer_id=" + tranfer_id +
                '}';
    }

}
