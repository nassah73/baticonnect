
package responsable;
import user_pak.Utilisateur;
import java.util.List;
import java.util.Objects;

public class Responsable extends Utilisateur  {
    private Long id;


    private String phoneNumber;
    private int yearsExperience;
    private List<Project> assignedProjects;
    private List<Report> createdReports;

    public Responsable() {
    }


    public Responsable(String nom, String prenom, String email, String motDePasse) {

        super(nom, prenom, email, motDePasse);



    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
