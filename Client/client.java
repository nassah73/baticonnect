package Client;
import user_pak.Utilisateur;
 class client extends Utilisateur {

    private float solde;
    private String ville;
    private String role="client";
    private String CardNumber;

    public client(String nom, String prenom, String email, int age, String adresse, String numeroTelephone, String motDePasse, String role, float solde, String ville) {
        super(nom, prenom, email, age, adresse, numeroTelephone, motDePasse, role);
        this.solde = solde;
        this.ville = ville;
    }
}
