package teacher_management_system.exercise.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    @NotNull(message = "Please enter the first Name")
    @Size(min = 1, message = "Please enter the first Name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull(message = "Please enter the last Name")
    @Size(min = 1, message = "Please enter the last Name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Please enter the email")
    @Size(min = 1, message = "Please enter the email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Please enter a valid email")
    private String email;

    // Constructors
    public Teacher() {

    }

    public Teacher(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
