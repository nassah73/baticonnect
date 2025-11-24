package project;

public class Project {
    private int project_id;
    private String project_name;
    private String project_description;
    private String date;
    private String status;
    private int resepteur_id;
    private int writer_id;
    public Project(int project_id, String project_name, String project_description, String date, String status, int resepteur_id, int writer_id) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.date = date;
        this.status = status;
        this.resepteur_id = resepteur_id;
        this.writer_id = writer_id;
   
    
}
    public int getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getResepteur_id() {
        return resepteur_id;
    }

    public int getWriter_id() {
        return writer_id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
    public void setResepteur_id(int resepteur_id) {
        this.resepteur_id = resepteur_id;
    }
    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
    

}
