package chief_PAK;

import user_pak.Utilisateur;
import java.util.*;

public class ChefDeChantier extends Utilisateur {
    private List<Projet> projets;
    private List<Rapport> rapports;
    private List<Demande> demandes;
    private List<Materiel> materiels;
    private List<GenerResponsable> responsables;

    public ChefDeChantier(String nom, String prenom, String email, int age,
                         String adresse, String telephone, String motDePasse) {
        super(nom, prenom, email, age, adresse, telephone, motDePasse, "chef_chantier");
        this.projets = new ArrayList<>();
        this.rapports = new ArrayList<>();
        this.demandes = new ArrayList<>();
        this.materiels = new ArrayList<>();
        this.responsables = new ArrayList<>();
    }

    // ✅ +surveiller(): void
    public void surveiller() {
        System.out.println("🔍 Surveillance des chantiers...");
        for (Projet projet : projets) {
            System.out.println("📊 " + projet.getTitle() + " - Progression: " + projet.getProgress() + "%");
        }
    }

    // ✅ +gererResponsables(): void
    public void gererResponsables() {
        System.out.println("👔 Gestion des responsables:");
        for (GenerResponsable resp : responsables) {
            System.out.println(" - " + resp.getRespoName() + " (CIN: " + resp.getCIN() + ")");
        }
    }

    // ✅ +voirlesProjets(): void
    public void voirlesProjets() {
        System.out.println("📋 Projets assignés:");
        for (Projet p : projets) {
            System.out.println("🏗️ " + p.getTitle() + " | " + p.getProgress() + "% | " + p.getStatus());
        }
    }

    // ✅ +voirRapports(): string
    public String voirRapports() {
        StringBuilder sb = new StringBuilder("📊 RAPPORTS:\n");
        for (Rapport r : rapports) {
            sb.append("• ").append(r.getContent()).append(" (").append(r.getDate()).append(")\n");
        }
        return sb.toString();
    }

    // ✅ +gererMateriaux(): void
    public void gererMateriaux() {
        System.out.println("🛠️ Inventaire des matériaux:");
        for (Materiel m : materiels) {
            System.out.println(" - " + m.getName() + ": " + m.getQuantite() + " " + m.getType());
        }
    }

    // ✅ +traiterDemandes(): void
    public void traiterDemandes() {
        System.out.println("📨 Traitement des demandes:");
        for (Demande d : demandes) {
            if ("en attente".equals(d.getStatus())) {
                System.out.println("✅ Traitement: " + d.getDescription());
                d.markAsSeen();
            }
        }
    }

    // Methodes d'ajout
    public void ajouterProjet(Projet projet) { this.projets.add(projet); }
    public void ajouterRapport(Rapport rapport) { this.rapports.add(rapport); }
    public void ajouterDemande(Demande demande) { this.demandes.add(demande); }
    public void ajouterMateriel(Materiel materiel) { this.materiels.add(materiel); }
    public void ajouterResponsable(GenerResponsable responsable) { this.responsables.add(responsable); }
}