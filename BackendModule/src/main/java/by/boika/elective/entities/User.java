package by.boika.elective.entities;

public class User extends Entity {
    private int id;
    private String firstName;
    private String secondName;
    private Role role;
    private String login;

    public User(int id, String firstName, String secondName, Role role, String login) {
        super(id);
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.login = login;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + secondName;
    }
}
