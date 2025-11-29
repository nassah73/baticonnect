package responsable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CompanyProjectRequest {
    private Long id;
    private String projectName;
    private String description;
    private ProjectCategory category;
    private String clientName;
    private BigDecimal budget;
    private String location;
    private RequestPriority priority;
    private LocalDateTime requestedAt;

    public CompanyProjectRequest() {
    }

    public CompanyProjectRequest(Long id, String projectName, String description, ProjectCategory category, String clientName, BigDecimal budget, String location, RequestPriority priority, LocalDateTime requestedAt) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.category = category;
        this.clientName = clientName;
        this.budget = budget;
        this.location = location;
        this.priority = priority;
        this.requestedAt = requestedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectCategory getCategory() {
        return category;
    }

    public void setCategory(ProjectCategory category) {
        this.category = category;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RequestPriority getPriority() {
        return priority;
    }

    public void setPriority(RequestPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    @Override
    public String toString() {
        return "CompanyProjectRequest{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", clientName='" + clientName + '\'' +
                ", budget=" + budget +
                ", location='" + location + '\'' +
                ", priority=" + priority +
                ", requestedAt=" + requestedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyProjectRequest that = (CompanyProjectRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
