package responsable;
import user_pak.Utilisateur;
public class Responsable extends Utilisateur {
            // les attributs
    private int cardNumber ;
    private String cin;
    private String role;

    // Constructeur
    
    public Responsable(int id,String nom, String prenom, String email, int age,
                  String adresse, String numeroTelephone, String motDePasse,
                  int crd, String ci,String role) {
        super(id,nom, prenom, email, age, adresse, numeroTelephone, motDePasse);
        this.cardNumber = crd;
        this.cin = ci;
        this.role = "Responsable";
    }
    
    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
   
}
