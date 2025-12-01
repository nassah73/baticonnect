package project;
import responsable.*;
import client.*;
import resources_chief.*;
public class Project {
    private int project_id;
    private String project_name;
    private String startDate;
    private String endDate;
    private double budget;
    private String localisation;
    private String status;
   
    
    public Project(int project_id, String project_name,double budget, String startDate, String endDate, String localisation, String status) {
        this.project_id = project_id;
        this.project_name = project_name;
       
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.localisation = localisation;
        this.status = status;
        
    }
    public Project(int project_id,String project_name,String startDate,String endDate,double budget,String localisation,String status){
        this.project_id=project_id;
        this.project_name=project_name;
        this.startDate=startDate;
        this.endDate=endDate;
        this.budget=budget;
        this.localisation=localisation;
        this.status=status;
    }
    public int getProjectid() {
        return project_id;
    }
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
    public String getProjectname() {
        return project_name;
    }
    public void setProjectname(String project_name) {
        this.project_name = project_name;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getLocalisation() {
        return localisation;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
   

    

}
