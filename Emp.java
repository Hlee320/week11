import java.io.Serializable;

public class Emp implements Serializable {
    private String id;
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String email;
/** *
     */
    public Emp() {
    }

    public Emp(String id, String name, String phoneNumber, String dateOfBirth, String
email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "" + "ID: " +id + ", Name:" + name + ", Phone:" + phoneNumber +
", Birth:" + dateOfBirth + ", Email:" + email ;
    }
}