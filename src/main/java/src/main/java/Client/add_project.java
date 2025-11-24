package src.main.java.Client;
import project.Project;
 class add_project {
    private int id;
    private String clientEmail;
    private Project project;
    public add_project(int id, String clientEmail, Project project) {
        this.id = id;
        this.clientEmail = clientEmail;
        this.project = project;
    }
    public int getId() {
        return id;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public Project getProject() {
        return project;
    }
}
