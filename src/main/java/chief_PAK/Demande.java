package chief_PAK;
import java.util.Date;

public class Demande {
    private int id;
    private String senderName;
    private Date date;
    private String description;
    private String status;

    public Demande(int id, String senderName, String description) {
        this.id = id;
        this.senderName = senderName != null ? senderName : "Inconnu";
        this.date = new Date();
        this.description = description != null ? description : "Aucune description fournie";
        this.status = "en attente";
    }

    // ✅ +MarkAsSeen()
    public void markAsSeen() {
        this.status = "vu";
        System.out.println("👁️ Demande #" + id + " marquée comme vue");
    }

    // ✅ +getDetails(): String
    public String getDetails() {
        return "📄 Demande #" + id + " de " + senderName + "\n" +
               "Description: " + description + "\n" +
               "Statut: " + status + " | Date: " + date;
    }

    // ✅ +assignTo(respo: GenerResponsable): void
    public void assignTo(GenerResponsable respo) {
        if (respo == null) {
            System.out.println("❌ Aucun responsable assigné à la demande #" + id);
        } else {
            System.out.println("👤 Demande #" + id + " assignée à " + respo.getRespoName());
        }
    }

    // ✅ +setStatus(newStatus: String): void
    public void setStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("📊 Statut de la demande #" + id + " mis à jour : " + status);
    }

    // Getters
    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}