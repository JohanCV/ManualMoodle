package unsa.edu.pe.manualmoodle;

public class Header {

    private String headercode;
    private String UserName;
    private String CreatedAt;

    public Header(String headercode, String userName, String createdAt) {
        this.headercode = headercode;
        this.UserName = userName;
        this.CreatedAt = createdAt;
    }

    public String getHeadercode() {
        return headercode;
    }

    public void setHeadercode(String headercode) {
        this.headercode = headercode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }
}
