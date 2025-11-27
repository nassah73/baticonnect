package resources_chief;

import java.util.Date;

public class ClientRequest
{
    private String clientName;
    private String projectName;
    private String category;
    private double budget;
    private String location;
    private Date deadline;
    private String priority;
    private String status;
    private Responsable assignedResponsable;

    public ClientRequest(String clientName, String projectName, String category, double budget, String location, Date deadline, String priority)
    {
        this.clientName = clientName;
        this.projectName = projectName;
        this.category = category;
        this.budget = budget;
        this.location = location;
        this.deadline = deadline;
        this.priority = priority;
        this.status = "Pending";
    }

    public void assignResponsable(Responsable r)
    {
        this.assignedResponsable = r;
    }

    public void accept()
    {
        this.status = "Accepted";
    }

    public void decline()
    {
        this.status = "Declined";
    }

    public void viewDetails()
    {
        System.out.println("Client: " + clientName + ", Projet: " + projectName + ", Budget: $" + budget + ", Status: " + status);
    }

    public String getStatus()
    {
        return status;
    }
}
