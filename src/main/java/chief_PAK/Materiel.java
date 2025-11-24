package chief_PAK;
public class Materiel {
    private String name;
    private double quantite;
    private String type;
    private int materiaux_id;

    // Constructeur
    public Materiel(String name, double quantite, String type, int materiaux_id) {
        this.name = name != null ? name : "Inconnu";
        this.quantite = quantite >= 0 ? quantite : 0;
        this.type = type != null ? type : "Non spécifié";
        this.materiaux_id = materiaux_id;
    }

    // ✅ Ajouter un matériel
    public void addMaterial() {
        System.out.println("➕ Ajout du matériel: " + name);
    }

    // ✅ Supprimer un matériel
    public void removeMaterial() {
        System.out.println("➖ Suppression du matériel: " + name);
    }

    // ✅ Mettre à jour la quantité de matériel
    public void updateMaterial(double nouvelleQuantite) {
        if (nouvelleQuantite >= 0) {
            this.quantite = nouvelleQuantite;
            System.out.println("🔄 Matériel " + name + " mis à jour: " + quantite);
        } else {
            System.out.println("❌ La quantité ne peut pas être négative.");
        }
    }

    // ✅ Afficher les détails du matériel
    public void afficherDetails() {
        System.out.println("📋 " + name + " | Qte: " + quantite + " | Type: " + type + " | ID: " + materiaux_id);
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getQuantite() {
        return quantite;
    }

    public String getType() {
        return type;
    }

    public int getMateriaux_id() {
        return materiaux_id;
    }

    // Setters
    public void setName(String name) {
        this.name = name != null ? name : "Inconnu";
    }

    public void setQuantite(double quantite) {
        if (quantite >= 0) {
            this.quantite = quantite;
        } else {
            System.out.println("❌ La quantité ne peut pas être négative.");
        }
    }

    public void setType(String type) {
        this.type = type != null ? type : "Non spécifié";
    }

    public void setMateriaux_id(int materiaux_id) {
        this.materiaux_id = materiaux_id;
    }
}