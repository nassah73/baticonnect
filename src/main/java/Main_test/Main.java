package Main_test;
import client.*;
public class Main {
    public static void main(String[] args) {
       project_client pr=new project_client(1,"Project A","Description A","Client A","ka",101,201,"2024-01-01","2024-12-31");
         System.out.println("Project Name: " + pr.gitproject_Name());
            System.out.println("Client Email: " + pr.getClientEmail());
    }
}
