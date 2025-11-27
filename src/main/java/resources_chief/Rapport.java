package resources_chief;

import java.util.Date;

public class Rapport
{
    private String type;
    private Responsable sender;
    private Projet project;
    private Date date;
    private String status;
    private String content;

    public Rapport(String type, Responsable sender, Projet project, Date date, String status, String content)
    {
        this.type = type;
        this.sender = sender;
        this.project = project;
        this.date = date;
        this.status = status;
        this.content = content;
    }

    public void viewReport()
    {
        System.out.println("Rapport: " + type + ", Projet: " + project.getName() + ", Envoyé par: " + sender.getName() + ", Status: " + status);
    }

    public void markReviewed()
    {
        this.status = "Reviewed";
    }

    public String getStatus()
    {
        return status;
    }
}
