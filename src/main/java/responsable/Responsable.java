<<<<<<< HEAD
package responsable;
import user_pak.Utilisateur;
public class Responsable extends Utilisateur {
=======
/*package responsable;

public class Responsable {
>>>>>>> 11d51b8960e3d9bd5bd4f82c7948c4069c693dc8
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
<<<<<<< HEAD
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCin() {
=======
   '
    public void setCardNumber(int crd) {
        this.cardNumber = crd;
    } 
    // Getter pour 'CIN'
    public String getCIN() {
>>>>>>> 11d51b8960e3d9bd5bd4f82c7948c4069c693dc8
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
    // test
*/
package responsable;

import java.util.List;
import java.util.Objects;

public class Responsable {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private int yearsExperience;
    private List<Project> assignedProjects;
    private List<Report> createdReports;

    public Responsable() {
    }

    public Responsable(Long id, String fullName, String email, String phoneNumber, int yearsExperience, List<Project> assignedProjects, List<Report> createdReports) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.yearsExperience = yearsExperience;
        this.assignedProjects = assignedProjects;
        this.createdReports = createdReports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public List<Project> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(List<Project> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    public List<Report> getCreatedReports() {
        return createdReports;
    }

    public void setCreatedReports(List<Report> createdReports) {
        this.createdReports = createdReports;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", assignedProjects=" + assignedProjects.size() + " projects" +
                ", createdReports=" + createdReports.size() + " reports" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responsable that = (Responsable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
