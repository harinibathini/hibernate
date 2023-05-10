package org.example;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TPC_PTE")
@DiscriminatorValue("part_time")
public class PartTimeEmp extends Employee{
    private int hrs_sal,no_of_hrs;

    public PartTimeEmp(int id, String name,int hrs_sal,int no_of_hrs) {
        super(id, name);
        this.hrs_sal = hrs_sal;
        this.no_of_hrs = no_of_hrs;

    }
}
