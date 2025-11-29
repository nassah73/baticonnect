package Main_test;
import client.*;
import database_managment.*;
public class Main {
    public static void main(String[] args) {
      /*   paymentProject testPayment = new paymentProject(1, 5000.0, "2024-06-15", "Credit Card", "hass@11", 101, 15000.0, 2000.0);
        System.out.println("Payment ID: " + testPayment.getPaymentId());
        System.out.println("Amount: " + testPayment.getAmount());
        System.out.println("Payment Date: " + testPayment.getPaymentDate());
        System.out.println("Payment Method: " + testPayment.getPaymentMethod());
        testPayment.pay();
        testPayment.displayPaymentInfo();*/
     Client client = new Client(1,"Doe", "John", "kkk",30,
             "123 Main St", "555-1234", "password123",
             1000.0f, "New York");
        System.out.println(client);
    }
}//int paymentId, double amount, String paymentDate, String paymentMethod,String clientEmail, int projectId, double projectBudget, double solde
