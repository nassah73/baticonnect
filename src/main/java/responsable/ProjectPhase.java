package responsable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ProjectPhase {
    private Long id;
    private String phaseName;
    private int progressPercentage;
    private LocalDateTime lastUpdated;
    private List<ProjectPhoto> photos;
    private String description;

    public ProjectPhase() {
    }

    public ProjectPhase(Long id, String phaseName, int progressPercentage, LocalDateTime lastUpdated, List<ProjectPhoto> photos, String description) {
        this.id = id;
        this.phaseName = phaseName;
        this.progressPercentage = progressPercentage;
        this.lastUpdated = lastUpdated;
        this.photos = photos;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<ProjectPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ProjectPhoto> photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProjectPhase{" +
                "id=" + id +
                ", phaseName='" + phaseName + '\'' +
                ", progressPercentage=" + progressPercentage +
                ", lastUpdated=" + lastUpdated +
                ", photos=" + photos.size() + " photos" +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPhase that = (ProjectPhase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
