package client;
import payment.Payment;
public class paymentProject extends Payment {
    private String clientEmail;
    private int projectId;
  
    private double solde;

    public paymentProject(int paymentId, double amount, String paymentDate, String paymentMethod,String clientEmail, int projectId, double solde) {
        super(paymentId, amount, paymentDate, paymentMethod);
        this.clientEmail = clientEmail;
        this.projectId = projectId;

        this.solde = solde;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public double getProjectBudget() {
        return projectBudget;
    }
    public void setProjectBudget(double projectBudget) {
        this.projectBudget = projectBudget;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void pay() {
        if (solde >= projectBudget) {
            solde -= projectBudget;
            System.out.println("Payment of " + projectBudget + " for project ID " + projectId + " has been processed.");
        } else {
            System.out.println("Insufficient balance to process the payment.");
        }
    }
    public void displayPaymentInfo() {
        System.out.println("Payment ID: " +super.getPaymentId());
        System.out.println("Amount: " + super.getAmount());
        System.out.println("Payment Date: " + super.getPaymentDate());
        System.out.println("Payment Method: " + super.getPaymentMethod());
        System.out.println("Client Email: " + clientEmail);
        System.out.println("Project ID: " + projectId);
        System.out.println("Project Budget: " + projectBudget);
        System.out.println("Client Solde: " + solde);
    }
   
}
