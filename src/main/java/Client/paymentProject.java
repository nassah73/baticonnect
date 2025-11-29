package client;

import payment.Payment;

public class paymentProject extends Payment {

    private String clientEmail;
    private int projectId;
    private Client client;

    public paymentProject(int paymentId, float amount, String paymentDate,
                          String paymentMethod, String clientEmail, int projectId,Client client) {
        super(paymentId, amount, paymentDate, paymentMethod);
        this.clientEmail = clientEmail;
        this.projectId = projectId;
        this.client=client;
    }
    public void setClient(Client client){
        this.client=client;
    }
    public Client getClient(){
        return client;
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





    public void pay() {
        float amount = super.getAmount();
        float currentSolde = this.client.getSolde();

        if (currentSolde >= amount) {
            this.client.setSolde(currentSolde - amount);
            System.out.println("Payment of " + amount +
                    " for project ID " + projectId +
                    " has been processed.");
        } else {
            System.out.println("Insufficient balance to process the payment.");
        }
    }


    public void displayPaymentInfo() {
        System.out.println("Payment ID: " + super.getPaymentId());
        System.out.println("Amount: " + super.getAmount());
        System.out.println("Payment Date: " + super.getPaymentDate());
        System.out.println("Payment Method: " + super.getPaymentMethod());
        System.out.println("Client Email: " + clientEmail);
        System.out.println("Project ID: " + projectId);
        System.out.println("Project Budget: " + super.getAmount());

    }
}

