package client;

import user_pak.Utilisateur;

 class Client extends Utilisateur {

    private float solde;
    private String ville;
    private String role = "client";
    private String cardNumber;

    public Client(String nom, String prenom, String email, int age,
                  String adresse, String numeroTelephone, String motDePasse,
                  float solde, String ville) {

        super(nom, prenom, email, age, adresse, numeroTelephone, motDePasse, "client");
        this.solde = solde;
        this.ville = ville;
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
}

