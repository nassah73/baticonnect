package responsable;

import java.util.Objects;

public class Worker {
    private Long id;
    private String fullName;
    private String role;
    private String phoneNumber;
    private WorkerStatus status;
    private Shift assignedShift;

    public Worker() {
    }

    public Worker(Long id, String fullName, String role, String phoneNumber, WorkerStatus status, Shift assignedShift) {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.assignedShift = assignedShift;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public WorkerStatus getStatus() {
        return status;
    }

    public void setStatus(WorkerStatus status) {
        this.status = status;
    }

    public Shift getAssignedShift() {
        return assignedShift;
    }

    public void setAssignedShift(Shift assignedShift) {
        this.assignedShift = assignedShift;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", assignedShiftId=" + (assignedShift != null ? assignedShift.getId() : "none") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
