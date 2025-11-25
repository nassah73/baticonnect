package client;
import project.Project;
 public class project_client extends Project {
    private int id_client;
    private String clientEmail;
    private String description;
     



    // Constructor that matches Project's required parameters
    public project_client(int project_id, String project_name, String description, String clientEmail, String localisation,String status, int id_client, double budget, String startDate, String endDate) {
        super(project_id, project_name, id_client, budget, startDate, endDate, localisation, status);
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
    public String gitprojectName() {
      return  super.getProjectname();
    }
    public void setprojectName(String project_name) {
        super.setProjectname(project_name);
    }
    public double getprojectBudget() {
        return super.getBudget();
    }
    public void setprojectBudget(double budget) {
        super.setBudget(budget);
    }
    public String getprojectStatus() {
        return super.getStatus();
    }
    public void setprojectStatus(String status) {
        super.setStatus(status);
    }
    public String getprojectLocalisation() {
        return super.getLocalisation();
    }
    public void setprojectLocalisation(String localisation) {
        super.setLocalisation(localisation);
    }
    public String getprojectStartDate() {
        return super.getStartDate();
    }
    public void setprojectStartDate(String startDate) {
        super.setStartDate(startDate);
    }
    public String getprojectEndDate() {
        return super.getEndDate();
    }
    public void setprojectEndDate(String endDate) {
        super.setEndDate(endDate);
    }
    public int getprojectResepteurid() {
        return super.getResepteurid();
    }
    public void setprojectResepteurid(int resepteur_id) {
        super.setResepteurid(resepteur_id);
    }
    public int getprojectId() {
        return super.getProjectid();
    }
    public void setprojectId(int project_id) {
        super.setProject_id(project_id);
    }
    public void displayProjectInfo() {
        System.out.println("Project ID: " + getprojectId());
        System.out.println("Project Name: " + gitprojectName());
        System.out.println("Description: " + getDescription());
        System.out.println("Client Email: " + getClientEmail());
        System.out.println("Localisation: " + getprojectLocalisation());
        System.out.println("Client ID: " + getId_client());
        System.out.println("Budget: " + getprojectBudget());
        System.out.println("Start Date: " + getprojectStartDate());
        System.out.println("End Date: " + getprojectEndDate());
        System.out.println("Status: " + getprojectStatus());
    }
    
}
