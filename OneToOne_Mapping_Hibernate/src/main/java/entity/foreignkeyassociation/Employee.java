package entity.foreignkeyassociation;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ForeignKeyAsEmployeeEntity")
@Table(name = "Employee", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"),@UniqueConstraint(columnNames = "EMAIL")})


public class Employee implements Serializable {
    //private static final long serialVersionUID = -1798070786993154676L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID", unique = true, nullable = false)
    private int employeeId;
   @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
   private String email;
    @Column(name = "FIRST_NAME", unique = true, nullable = false, length = 100)
    private String firstName;
    @Column(name = "LAST_NAME", unique = true, nullable = false, length = 100)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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
