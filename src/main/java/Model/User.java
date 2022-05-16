package Model;

public class User {
    private int id;
    private String firstName;
    private String otherNames;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;
    private String fullName;


    public User(int id, String firstName, String otherNames, String surname, String email, String password, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;

    }

    public String getFullName() {
        return this.firstName + " " + this.surname;
    }

    public void setFullName() {
        this.fullName = this.firstName + " " + this.surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
