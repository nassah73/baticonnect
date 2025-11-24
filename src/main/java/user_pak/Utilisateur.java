package user_pak;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private int age;
    private String adresse;
    private String numeroTelephone;
    private String motDePasse;
    private String role;
    
    public Utilisateur(String nom, String prenom, String email, int age, String adresse, String numeroTelephone, String motDePasse, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.motDePasse = motDePasse;
        this.role = role;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getNumeroTelephone() {
        return numeroTelephone;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public String getRole() {
        return role;
    }
    

}
