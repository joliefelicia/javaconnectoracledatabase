public class student {
    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }


    private int id;
    private String username;
    private String fullname;

    public student(int id, String username, String fullname) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
    }
}
