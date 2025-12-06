package client;

import user_pak.Utilisateur;

public class Client extends Utilisateur {

    private float solde;
    private String ville;
    private String role;
    private String cardNumber;

    public Client(int id,String nom, String prenom, String email, int age,
                  String adresse, String numeroTelephone, String motDePasse,
                  float solde, String ville) {

        super(id,nom, prenom, email, age, adresse, numeroTelephone, motDePasse);
        this.solde = solde;
        this.ville = ville;
        this.role = "Client";
    }
    public Client(String nom, String prenom, String email, String motDePasse) {

        super(nom, prenom, email, motDePasse);
        this.role = "client";

        this.solde = 0.0f;
        this.ville = "";
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean verifierCarte() {
    return cardNumber != null && cardNumber.length() == 16;
}
    public String getRole() {
        return role;
    }
    @Override
public String toString() {
    return "Client{" +
            "nom=" + super.getNom() +
            ", prenom=" + super.getPrenom() +
            ", solde=" + solde +
            ", ville='" + ville + '\'' +
            '}';
}

}

