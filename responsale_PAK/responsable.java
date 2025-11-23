package responsale_PAK;

public class responsable {
            // les attributs
    private int cardNumber ;
    private String cin;

    // Constructeur
    public responsable(int crd,String ci ){
        this.cardNumber=crd;
        this.cin=ci;
    }  
    // Getter pour 'cardNumber'
    public int getCardNumber() {
        return cardNumber;
    }
    // Setter pour 'cardNumber'
    public void setCardNumber(int crd) {
        this.cardNumber = crd;
    } 
    // Getter pour 'CIN'
    public String getCIN() {
        return cin;
    }
    // Setter pour 'CIN'
    public void setCIN(String ci) {
        this.cin = ci;
    } 
    // les methodes
    public void gererDemandes(){
    }

    public boolean envoyerRapports(){
       return false;
    }

    public void gererRessources(){
    }

    public void modifierProfil(){
    }
}
