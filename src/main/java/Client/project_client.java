package client;
import project.Project;
 public class project_client extends Project {
    private int id_client;
    private String clientEmail;
    private String description;
     



    // Constructor that matches Project's required parameters
    public project_client(int project_id,String project_name,String startDate,String endDate,double budget,String localisation,String status,int id_client,String clientEmail,String description) {
        super( project_id, project_name, startDate, endDate, budget, localisation, status);
        this.id_client = id_client;
        this.clientEmail = clientEmail;
        this.description = description;
    }
    
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    public void displayProjectInfo() {
        System.out.println("Project ID: " + super.getProjectid());
        System.out.println("Project Name: " + super.getProjectname());
        System.out.println("Description: " + getDescription());
        System.out.println("Client Email: " + getClientEmail());
        System.out.println("Localisation: " + super.getLocalisation());
        System.out.println("Client ID: " + getId_client());
        System.out.println("Budget: " + super.getBudget());
        System.out.println("Start Date: " + super.getStartDate());
        System.out.println("End Date: " + super.getEndDate());
        System.out.println("Status: " + super.getStatus());
    }
    public String toString() {
        return "project_client{" +
                "id_client=" + id_client +
                ", clientEmail='" + clientEmail + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
    
}
