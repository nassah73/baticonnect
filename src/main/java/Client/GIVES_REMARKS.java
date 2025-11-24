package Client;

 class gives_Remarks {
    private int id;
    private String remark_title;
    private String clientEmail;
    private add_project project_id;
    private String remark_content;
    private String remark_date;
    public gives_Remarks(int id, String remark_title, String clientEmail, String remark_content, String remark_date, add_project project_id) {
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

}
