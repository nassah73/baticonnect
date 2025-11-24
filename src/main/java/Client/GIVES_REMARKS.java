package Client;

 class gives_Remarks {
    private int id;
    private String remark_title;
    private String clientEmail;
    private String resepteurEmail;
    private String remark_content;
    private String remark_date;
    public gives_Remarks(int id, String remark_title, String clientEmail, String remark_content, String remark_date, String resepteurEmail) {
        this.id = id;
        this.remark_title = remark_title;
        this.clientEmail = clientEmail;
        this.remark_content = remark_content;
        this.remark_date = remark_date;
        this.resepteurEmail = resepteurEmail;
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

}
