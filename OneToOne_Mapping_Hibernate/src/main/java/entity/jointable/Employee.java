package entity.jointable;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "JoinTableEmployeeEntity")
@Table(name = "Employee", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"),@UniqueConstraint(columnNames = "EMAIL")})


public class Employee implements Serializable {
    //private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer employeeId;
    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;
    @Column(name = "FIRST_NAME", unique = true, nullable = false, length = 100)
    private String firstName;
    @Column(name = "LAST_NAME", unique = true, nullable = false, length = 100)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_ACCOUNT", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID"))
    private Account account;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}

