package responsable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Project {
    private Long id;
    private String name;
    private String clientName;
    private ProjectCategory category;
    private String location;
    private BigDecimal budget;
    private LocalDate startDate;
    private LocalDate estimatedEndDate;
    private ProgressStatus progressStatus;
    private List<ProjectPhase> phases;

    public Project() {
    }

    public Project(Long id, String name, String clientName, ProjectCategory category, String location, BigDecimal budget, LocalDate startDate, LocalDate estimatedEndDate, ProgressStatus progressStatus, List<ProjectPhase> phases) {
        this.id = id;
        this.name = name;
        this.clientName = clientName;
        this.category = category;
        this.location = location;
        this.budget = budget;
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.progressStatus = progressStatus;
        this.phases = phases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ProjectCategory getCategory() {
        return category;
    }

    public void setCategory(ProjectCategory category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public void setEstimatedEndDate(LocalDate estimatedEndDate) {
        this.estimatedEndDate = estimatedEndDate;
    }

    public ProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public List<ProjectPhase> getPhases() {
        return phases;
    }

    public void setPhases(List<ProjectPhase> phases) {
        this.phases = phases;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clientName='" + clientName + '\'' +
                ", category=" + category +
                ", location='" + location + '\'' +
                ", budget=" + budget +
                ", startDate=" + startDate +
                ", estimatedEndDate=" + estimatedEndDate +
                ", progressStatus=" + progressStatus +
                ", phases=" + phases.size() + " phases" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

