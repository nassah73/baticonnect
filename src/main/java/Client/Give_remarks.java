package client;

 public class Give_remarks {
    private int id;
    private String remark_title;
    private String clientEmail;
    private add_project project_id;
    private String remark_content;
    private String remark_date;
    public Give_remarks(int id, String remark_title, String clientEmail, String remark_content, String remark_date, add_project project_id) {
        this.id = id;
        this.remark_title = remark_title;
        this.clientEmail = clientEmail;
        this.remark_content = remark_content;
        this.remark_date = remark_date;
        this.project_id = project_id;
        
    }
    public int getId() {
        return id;
    }
    public String getRemark_title() {
        return remark_title;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public String getRemark_content() {
        return remark_content;
    }
    public String getRemark_date() {
        return remark_date;
    }
    public add_project getProject_id() {
        return project_id;
    }
    public void dysplayRemark() {
        System.out.println("Remark ID: " + id);
        System.out.println("Remark Title: " + remark_title);
        System.out.println("Client Email: " + clientEmail);
        System.out.println("Remark Content: " + remark_content);
        System.out.println("Remark Date: " + remark_date);

    }

}
