package Client;
import project.Project;
 class add_project extends Project {
    private int id;
    private String clientEmail;

    // No-arg constructor that calls superclass constructor with default values
    public add_project() {
        super(0, "", "", "", "", 0, 0);
    }

    // Constructor that matches Project's required parameters
    public add_project(int id, String name, String description, String clientName, String clientEmail, int startDate, int endDate) {
        super(id, name, description, clientName, clientEmail, startDate, endDate);
        this.id = id;
        this.clientEmail = clientEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
