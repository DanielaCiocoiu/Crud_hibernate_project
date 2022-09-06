package com.personalProject.Enterprise_employees_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "address")
    private String address;

    // OneToOne Bi
    @OneToOne(mappedBy = "employeeDetail")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference //avoid app to enter in an infinite loop / infinite recursion Stackoverflow error.
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDetail that = (EmployeeDetail) o;
        return id == that.id && salary.equals(that.salary) && address.equals(that.address) && employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, address, employee);
    }

//mappedBy tells Hibernate - look at the employeeDetail property in the Employee class
}
