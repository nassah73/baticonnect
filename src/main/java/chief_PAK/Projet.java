package chief_PAK;
public class Projet {
    private int project_id;
    private String title;
    private int progress;
    private String status;
    private double budget;
    private String localisation;

    // Constructeur
    public Projet(int id, String title, double budget, String localisation) {
        this.project_id = id;
        this.title = title != null ? title : "Sans titre";
        this.budget = budget >= 0 ? budget : 0;
        this.localisation = localisation != null ? localisation : "Non spécifiée";
        this.progress = 0;
        this.status = "planifié";
    }

    // ✅ Ajouter un projet
    public void addProject() {
        System.out.println("✅ Projet '" + title + "' ajouté avec ID: " + project_id);
    }

    // ✅ Supprimer un projet
    public void removeProject() {
        System.out.println("🗑️ Projet '" + title + "' supprimé");
    }

    // ✅ Mettre à jour la progression
    public void updateProgress(int progress) {
        if (progress < 0 || progress > 100) {
            System.out.println("❌ La progression doit être comprise entre 0 et 100.");
            return;
        }
        this.progress = progress;
        if (progress == 100) {
            this.status = "terminé";
        } else if (progress > 0) {
            this.status = "en cours";
        } else {
            this.status = "planifié";
        }
        System.out.println("🔄 Progression mise à jour: " + progress + "% | Statut: " + status);
    }

    // ✅ Afficher les détails du projet
    public void afficherDetails() {
        System.out.println("📋 Projet #" + project_id);
        System.out.println("Titre: " + title);
        System.out.println("Budget: " + budget + " €");
        System.out.println("Localisation: " + localisation);
        System.out.println("Progression: " + progress + "%");
        System.out.println("Statut: " + status);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getProgress() {
        return progress;
    }

    public String getStatus() {
        return status;
    }

    public double getBudget() {
        return budget;
    }

    public String getLocalisation() {
        return localisation;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title != null ? title : "Sans titre";
    }

    public void setBudget(double budget) {
        if (budget >= 0) {
            this.budget = budget;
        } else {
            System.out.println("❌ Le budget ne peut pas être négatif.");
        }
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation != null ? localisation : "Non spécifiée";
    }
}