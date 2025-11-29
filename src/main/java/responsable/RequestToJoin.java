package responsable;

import java.time.LocalDate;
import java.util.Objects;

public class RequestToJoin {
    private Long id;
    private Long responsableId;
    private CompanyProjectRequest companyProjectRequest;
    private String motivation;
    private String experienceSummary;
    private int proposedTeamSize;
    private LocalDate availabilityDate;
    private RequestStatus status;

    public RequestToJoin() {
    }

    public RequestToJoin(Long id, Long responsableId, CompanyProjectRequest companyProjectRequest, String motivation, String experienceSummary, int proposedTeamSize, LocalDate availabilityDate, RequestStatus status) {
        this.id = id;
        this.responsableId = responsableId;
        this.companyProjectRequest = companyProjectRequest;
        this.motivation = motivation;
        this.experienceSummary = experienceSummary;
        this.proposedTeamSize = proposedTeamSize;
        this.availabilityDate = availabilityDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Long responsableId) {
        this.responsableId = responsableId;
    }

    public CompanyProjectRequest getCompanyProjectRequest() {
        return companyProjectRequest;
    }

    public void setCompanyProjectRequest(CompanyProjectRequest companyProjectRequest) {
        this.companyProjectRequest = companyProjectRequest;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getExperienceSummary() {
        return experienceSummary;
    }

    public void setExperienceSummary(String experienceSummary) {
        this.experienceSummary = experienceSummary;
    }

    public int getProposedTeamSize() {
        return proposedTeamSize;
    }

    public void setProposedTeamSize(int proposedTeamSize) {
        this.proposedTeamSize = proposedTeamSize;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RequestToJoin{" +
                "id=" + id +
                ", responsableId=" + responsableId +
                ", companyProjectRequestId=" + (companyProjectRequest != null ? companyProjectRequest.getId() : "none") +
                ", motivation='" + motivation + '\'' +
                ", experienceSummary='" + experienceSummary + '\'' +
                ", proposedTeamSize=" + proposedTeamSize +
                ", availabilityDate=" + availabilityDate +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestToJoin that = (RequestToJoin) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
