package chief_PAK;
public class GenerResponsable {
    private String respoName;
    private String cin;
    private String etat;
    private Projet project;

    public GenerResponsable(String respoName, String cin, String etat) {
        this.respoName = respoName != null ? respoName : "Inconnu";
        this.cin = cin != null ? cin : "Non spécifié";
        this.etat = etat != null ? etat : "actif";
    }

    // ✅ Gérer l'adresse du responsable
    public void handleAddress() {
        System.out.println("📍 Adresse du responsable " + respoName + " traitée");
    }

    // ✅ Révoquer le responsable
    public void revokeResponsable() {
        if ("révoqué".equalsIgnoreCase(etat)) {
            System.out.println("⚠️ Le responsable " + respoName + " est déjà révoqué.");
        } else {
            System.out.println("🔄 Révocation du responsable " + respoName);
            this.etat = "révoqué";
        }
    }

    // Getters
    public String getRespoName() {
        return respoName;
    }

    public String getCIN() {
        return cin;
    }

    public String getEtat() {
        return etat;
    }

    public Projet getProject() {
        return project;
    }

    // Setter pour le projet
    public void setProject(Projet project) {
        this.project = project;
    }
}