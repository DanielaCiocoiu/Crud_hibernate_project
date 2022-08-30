package com.personalProject.Enterprise_employees_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="employee_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NonNull
    @Column(name = "salary")
    private Integer salary;

    @NonNull
    @Column(name = "address")
    private String address;

    // OneToOne Bi
    @NonNull
    @OneToOne(mappedBy="employeeDetail", cascade=CascadeType.ALL)
    @JsonBackReference //avoid app to enter in an infinite loop / infinite recursion Stackoverflow error.
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDetail that = (EmployeeDetail) o;
        return salary == that.salary && address.equals(that.address) && employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, address, employee);
    }

    //mappedBy tells Hibernate - look at the employeeDetail property in the Employee class
}
