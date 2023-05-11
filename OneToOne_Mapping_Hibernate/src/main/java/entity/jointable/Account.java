package entity.jointable;

import entity.jointable.Employee;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ForeignKeyAsAccountEntity")
@Table(name = "ACCOUNT", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer accountId;

    @OneToOne(mappedBy = "account")
    private entity.foreignkeyassociation.Employee employee;
    @Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
    private String accountNumber;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public entity.foreignkeyassociation.Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", employee=" + employee +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}

