package com.personalProject.Enterprise_employees_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phones")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type_phone")
    private TypePhone typePhone;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    @JsonBackReference
    private Employee employee;

//@ManyToOne and @OneToOne associations use the FetchType.EAGER strategy which is bad for performance


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone))
            return false;
        return id != null &&  id.equals(((Phone) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
