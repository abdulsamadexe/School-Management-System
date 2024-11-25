

public abstract class Person {
    protected String name;
    protected String email;
    protected String dateOfBirth;

    public Person(String name, String email, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setEmail(String email) {
        this.email = email;
    }


    String getEmail() {
        return email;
    }

    void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    String getDateOfBirth() {
        return dateOfBirth;
    }

    public abstract String displayDetails();
}