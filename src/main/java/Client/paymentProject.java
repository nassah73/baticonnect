package client;
import payment.Payment;
public class paymentProject extends Payment {
    private String clientEmail;
    private int projectId;

    private double solde;

    public paymentProject(int paymentId, double amount, String paymentDate, String paymentMethod,String clientEmail, int projectId) {
        super(paymentId, amount, paymentDate, paymentMethod);
        this.clientEmail = clientEmail;
        this.projectId = projectId;


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


    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void pay() {
        if (solde >= super.getAmount()) {
            solde -= super.getAmount();
            System.out.println("Payment of " + super.getAmount() + " for project ID " + projectId + " has been processed.");
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
        System.out.println("Project Budget: " + super.getAmount());
        System.out.println("Client Solde: " + solde);
    }
   
}
