package com.personalProject.Enterprise_employees_management_system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor

//@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "departament")
    private Departament departament;

    @NonNull
    @Column(name="date_of_birth")
    private Date dateOfBirth;

    // Owning side
    @NonNull
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="employee_detail_id", nullable = false)
    @JsonManagedReference  //avoid app to enter in an infinite loop / infinite recursion Stackoverflow error.
    private EmployeeDetail employeeDetail;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && email.equals(employee.email) && departament == employee.departament && dateOfBirth.equals(employee.dateOfBirth) && Objects.equals(employeeDetail, employee.employeeDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, departament, dateOfBirth, employeeDetail);
    }
}
