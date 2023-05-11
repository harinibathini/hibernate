package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    private int eid;
    private String ename;
    @ManyToMany
    @JoinTable(name = "Employee_Project_Relation",  //to change the name of extra(relational) table
            joinColumns = {@JoinColumn(name = "eid")},
    inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Project> projects;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee(int eid, String ename, List<Project> projects) {
        this.eid = eid;
        this.ename = ename;
        this.projects = projects;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", projects=" + projects +
                '}';
    }
}
