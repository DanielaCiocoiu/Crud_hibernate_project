package com.personalProject.Enterprise_employees_management_system.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "salary")
    private int salary;

    @NonNull
    @Column(name = "address")
    private String address;

    // add @OneToOne annotation
    @NonNull
    @OneToOne(mappedBy="employee_detail", cascade=CascadeType.ALL)
    private Employee employee;

}
