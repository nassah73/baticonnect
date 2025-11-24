package chief_PAK;
import java.util.Date;

public class Rapport {
    private int rapport_id;
    private GenerResponsable responsable;
    private Date date;
    private String content;
    private String status;
    private Projet project;

    // Constructeur
    public Rapport(int id, String content, GenerResponsable resp, Projet proj) {
        this.rapport_id = id;
        this.content = content != null ? content : "Aucun contenu";
        this.responsable = resp;
        this.project = proj;
        this.date = new Date();
        this.status = "brouillon";
    }

    // ✅ Valider le rapport
    public void validate() {
        this.status = "validé";
        System.out.println("✅ Rapport #" + rapport_id + " validé");
    }

    // ✅ Obtenir les détails du rapport
    public void getDetails() {
        System.out.println("📋 Rapport #" + rapport_id);
        System.out.println("Projet: " + (project != null ? project.getTitle() : "Aucun projet associé"));
        System.out.println("Responsable: " + (responsable != null ? responsable.getRespoName() : "Aucun responsable associé"));
        System.out.println("Contenu: " + content);
        System.out.println("Statut: " + status + " | Date: " + date);
    }

    // ✅ Marquer comme vu
    public void markAsSeen() { // Renommé pour respecter camelCase
        System.out.println("👁️ Rapport #" + rapport_id + " marqué comme vu");
    }

    // Getters
    public int getRapportId() {
        return rapport_id;
    }

    public GenerResponsable getResponsable() {
        return responsable;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public Projet getProject() {
        return project;
    }

    // Setters
    public void setContent(String content) {
        this.content = content != null ? content : "Aucun contenu";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResponsable(GenerResponsable responsable) {
        this.responsable = responsable;
    }

    public void setProject(Projet project) {
        this.project = project;
    }
}