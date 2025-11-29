package resources_chief;
import responsable.Responsable;
import client.project_client;
import user_pak.Utilisateur;
import java.util.List;

public class ChefDeChantier extends Utilisateur {
    private List<project_client> assignedProjects;
    private String role;

    public ChefDeChantier(int id,String nom, String prenom, String email, int age,
                  String adresse, String numeroTelephone, String motDePasse,
                  List<project_client> assignedProjects) {
        super(id,nom, prenom, email, age, adresse, numeroTelephone, motDePasse);
        this.assignedProjects = assignedProjects;
        this.role = "ChefDeChantier";
    }

    public List<project_client> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(List<project_client> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    public String getRole() {
        return role;

}

}
