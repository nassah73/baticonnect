package client;

 public class Give_remarks {
    private int id;
    private String remark_title;
    private String clientEmail;
    private int project_id;
    private String remark_content;
    private String remark_date;
    public Give_remarks(int id, String remark_title, String clientEmail, int project_id, String remark_content, String remark_date) {
        this.id = id;
        this.remark_title = remark_title;
        this.clientEmail = clientEmail;
        this.project_id = project_id;
        this.remark_content = remark_content;
        this.remark_date = remark_date;

        if (remark_title == null || remark_title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }



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
    public int getProject_id() {
        return project_id;
    }
    public void dysplayRemark() {
        System.out.println("Remark ID: " + id);
        System.out.println("Remark Title: " + remark_title);
        System.out.println("Client Email: " + clientEmail);
        System.out.println("Remark Content: " + remark_content);
        System.out.println("Remark Date: " + remark_date);

    }
     @Override
     public String toString() {
         return "Remark{" +
                 "id=" + id +
                 ", title='" + remark_title + '\'' +
                 ", email='" + clientEmail + '\'' +
                 ", content='" + remark_content + '\'' +
                 ", date='" + remark_date + '\'' +
                 ", project_id=" + project_id +
                 '}';
     }


 }
