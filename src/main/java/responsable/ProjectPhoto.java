
package responsable;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProjectPhoto {
    private Long id;
    private String url;
    private LocalDateTime uploadedAt;

    public ProjectPhoto() {
    }

    public ProjectPhoto(Long id, String url, LocalDateTime uploadedAt) {
        this.id = id;
        this.url = url;
        this.uploadedAt = uploadedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    @Override
    public String toString() {
        return "ProjectPhoto{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", uploadedAt=" + uploadedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectPhoto that = (ProjectPhoto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}