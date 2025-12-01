package client;
import responsable.Responsable;
public class Rapport_client {
     private int Rapport_id;
     private Responsable responsable;
     private String Rapport_content;
    private String Rapport_title;
    private String Rapport_date;
    private String Rapport_project;
    private String Rapport_status;
    private String Rapport_comments;

    public Rapport_client(int rapport_id, Responsable responsable, String rapport_content, String rapport_title, String rapport_date, String rapport_project, String rapport_status, String rapport_comments) {
        Rapport_id = rapport_id;
        this.responsable = responsable;
        Rapport_content = rapport_content;
        Rapport_title = rapport_title;
        Rapport_date = rapport_date;
        Rapport_project = rapport_project;
        Rapport_status = rapport_status;
        Rapport_comments = rapport_comments;
    }
    public int getRapport_id() {
        return Rapport_id;
    }
    public void setRapport_id(int rapport_id) {
        Rapport_id = rapport_id;
    }
    public Responsable getResponsable() {
        return responsable;
    }
    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    public String getRapport_content() {
        return Rapport_content;
    }
    public void setRapport_content(String rapport_content) {
        Rapport_content = rapport_content;
    }
    public String getRapport_title() {
        return Rapport_title;
    }
    public void setRapport_title(String rapport_title) {
        Rapport_title = rapport_title;
    }
    public String getRapport_date() {
        return Rapport_date;
    }
    public void setRapport_date(String rapport_date) {
        Rapport_date = rapport_date;
    }
    public String getRapport_project() {
        return Rapport_project;
    }
    public void setRapport_project(String rapport_project) {
        Rapport_project = rapport_project;
    }
    public String getRapport_status() {
        return Rapport_status;
    }
    public void setRapport_status(String rapport_status) {
        Rapport_status = rapport_status;
    }
    public String getRapport_comments() {
        return Rapport_comments;
    }
    public void setRapport_comments(String rapport_comments) {
        Rapport_comments = rapport_comments;
    }

    public String toString() {
        return "Rapport_client{" +
                "Rapport_id=" + Rapport_id +
                ", responsable=" + responsable +
                ", Rapport_content='" + Rapport_content + '\'' +
                ", Rapport_title='" + Rapport_title + '\'' +
                ", Rapport_date='" + Rapport_date + '\'' +
                ", Rapport_project='" + Rapport_project + '\'' +
                ", Rapport_status='" + Rapport_status + '\'' +
                ", Rapport_comments='" + Rapport_comments + '\'' +
                '}';
    }
    

}
