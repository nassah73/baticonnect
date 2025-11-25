package client;
import project.Project;
 public class project_client extends Project {
    private int id_client;
    private String clientEmail;
    private String startDate;
    private String endDate;



    // Constructor that matches Project's required parameters
    public project_client(int id, String name, String description, String clientName, String clientEmail,int id_client,int id_reseptuer, String startDate, String endDate) {
        super(id, name, description, clientName, clientEmail, id_client, id_reseptuer);
        this.clientEmail = clientEmail;
        this.startDate = startDate;
        this.endDate = endDate;

    }
    public String gitproject_Name() {
        return super.getProject_name();
    }

   public int getId() {
        return id_client;
    }

    public void setId(int id_client) {
        this.id_client = id_client;
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
    

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
