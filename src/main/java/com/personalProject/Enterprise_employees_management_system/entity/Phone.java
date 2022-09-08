package com.personalProject.Enterprise_employees_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phones")
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone", nullable = false)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_phone")
    private TypePhone typePhone;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @ManyToOne()
    @JoinColumn(name="employee_id")
    @JsonBackReference
    private Employee employee;

//@ManyToOne and @OneToOne associations use the FetchType.EAGER
// strategy which is bad for performance


/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone))
            return false;
        return id != null &&  id.equals(((Phone) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return typePhone == phone.typePhone && Objects.equals(phoneNumber, phone.phoneNumber) && Objects.equals(employee, phone.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typePhone, phoneNumber, employee);
    }

    /*  The child entity, PostComment, implement the equals and hashCode methods.
    Since we cannot rely on a natural identifier for equality checks,
    we need to use the entity identifier instead for the equals method.
        However, you need to do it properly so that equality is consistent across
    all entity state transitions, which is also the reason why the hashCode
    has to be a constant value. Because we rely on equality for the removeComment,
    it’s good practice to override equals and hashCode for the child entity in a bidirectional association.*/
}
