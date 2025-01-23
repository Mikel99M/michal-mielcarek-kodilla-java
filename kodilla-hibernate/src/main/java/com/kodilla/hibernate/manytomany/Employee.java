package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Employee.retrieveEmployeeByLastName",
        query = "FROM Employee WHERE lastName = :LASTNAME"
)
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private int id;
    private String fristName;
    private String lastName;
    private List<Company> companies = new ArrayList<Company>();

    public Employee() {}

    public Employee(String fristName, String lastName) {
        this.fristName = fristName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFristName() {
        return fristName;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFristName(String fristName) {
        this.fristName = fristName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
