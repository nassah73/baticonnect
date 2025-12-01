package resources_chief;
import project.Project;
import java.util.ArrayList;
import java.util.List;

public class Projet extends Project {
    private Responsable manager;
    private int overallProgress;
    private List<Rapport> rapports;

    // Constructeur
    public Projet(int project_id, String project_name, double budget, String startDate, String endDate, String localisation, String status, Responsable manager, int overallProgress, List<Rapport> rapports) {
        super(project_id, project_name, budget, startDate, endDate, localisation, status);
        this.manager = manager; // Initialisation du manager
        this.overallProgress = (overallProgress >= 0 && overallProgress <= 100) ? overallProgress : 0; // Validation de la progression
        this.rapports = (rapports != null) ? rapports : new ArrayList<>(); // Initialisation de la liste des rapports
    }

    // Getter pour le manager
    public Responsable getManager() {
        return manager;
    }

    // Setter pour le manager
    public void setManager(Responsable manager) {
        this.manager = manager;
    }

    // Getter pour la progression globale
    public int getOverallProgress() {
        return overallProgress;
    }

    // Setter pour la progression globale
    public void setOverallProgress(int overallProgress) {
        if (overallProgress >= 0 && overallProgress <= 100) {
            this.overallProgress = overallProgress;
        } else {
            System.out.println("❌ La progression doit être comprise entre 0 et 100.");
        }
    }

    // Getter pour les rapports
    public List<Rapport> getRapports() {
        return rapports;
    }

    // Setter pour les rapports
    public void setRapports(List<Rapport> rapports) {
        if (rapports != null) {
            this.rapports = rapports;
        } else {
            System.out.println("❌ La liste des rapports ne peut pas être null.");
        }
    }

    // Afficher la progression du projet
    public void showProgress() {
        System.out.println("Projet: " + getProjectname() + " - Progress: " + overallProgress + "%");
    }
}
