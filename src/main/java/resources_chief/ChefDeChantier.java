package resources_chief;

import client.project_client;
import user_pak.Utilisateur;
import java.util.List; // تأكد من وجود هذا الاستيراد

public class ChefDeChantier extends Utilisateur {
    private List<project_client> assignedProjects;
    private String role; // هذا الحقل يمكن أن يكون مُعرفاً في كلاس Utilisateur

    // 1. المُنشئ الفارغ (ضروري في بعض الأحيان)
    public ChefDeChantier() {
        super();
        this.role = "ChefDeChantier";
    }

    // 2. المُنشئ الكامل (الموجود لديك)
    public ChefDeChantier(int id,String nom, String prenom, String email, int age,
                          String adresse, String numeroTelephone, String motDePasse,
                          List<project_client> assignedProjects) {
        super(id,nom, prenom, email, age, adresse, numeroTelephone, motDePasse);
        this.assignedProjects = assignedProjects;
        this.role = "ChefDeChantier";
    }

    // 3. مُنشئ مُبسط لاستقبال البيانات من الواجهة
    // نضيف هذا المُنشئ لتسهيل إنشاء الكائن من الواجهة
    public ChefDeChantier(String nom, String prenom, String email, String motDePasse) {
        super(0, nom, prenom, email, 0, null, null, motDePasse); // قيم افتراضية مؤقتة
        this.role = "ChefDeChantier";
        this.assignedProjects = null;
    }

    // Getters and Setters (كما هي)
    public List<project_client> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(List<project_client> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) { // إضافة setRole
        this.role = role;
    }
}
