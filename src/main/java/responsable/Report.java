package responsable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Report {
    private Long id;
    private String title;
    private ReportRecipientType recipientType;
    private Project project;
    private String content;
    private List<String> attachmentUrls;
    private LocalDateTime createdAt;

    public Report() {
    }

    public Report(Long id, String title, ReportRecipientType recipientType, Project project, String content, List<String> attachmentUrls, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.recipientType = recipientType;
        this.project = project;
        this.content = content;
        this.attachmentUrls = attachmentUrls;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReportRecipientType getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(ReportRecipientType recipientType) {
        this.recipientType = recipientType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachmentUrls() {
        return attachmentUrls;
    }

    public void setAttachmentUrls(List<String> attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", recipientType=" + recipientType +
                ", projectId=" + (project != null ? project.getId() : "none") +
                ", content='" + content.substring(0, Math.min(content.length(), 30)) + (content.length() > 30 ? "..." : "") + '\'' +
                ", attachmentUrls=" + attachmentUrls.size() + " urls" +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(id, report.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
