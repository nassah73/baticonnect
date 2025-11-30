package project;
import client.*;
import responsable.*;
import resources_chief.*;
public class Project {
    private int project_id;
    private String project_name;
    private String startDate;
    private String endDate;
    private double budget;
    private String localisation;
    private String status;
    private String recepteur_role;
    private int resepteur_id;
    
    public Project(int project_id, String project_name,String recepteur_role, int resepteur_id,double budget, String startDate, String endDate, String localisation, String status) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.resepteur_id = resepteur_id;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.localisation = localisation;
        this.status = status;
        this.recepteur_role= recepteur_role;
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
    public int getResepteurid() {
        return resepteur_id;
    }
    public void setResepteurid(int resepteur_id) {
        this.resepteur_id = resepteur_id;
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
    public String getRecepteur_role() {
        return recepteur_role;
    }
    public void setRecepteur_role(String recepteur_role) {
        this.recepteur_role = recepteur_role;
    }

    

}
