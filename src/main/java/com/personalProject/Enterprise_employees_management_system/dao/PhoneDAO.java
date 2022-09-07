package com.personalProject.Enterprise_employees_management_system.dao;

import com.personalProject.Enterprise_employees_management_system.entity.Phone;

import java.util.List;

public interface PhoneDAO {
    List<Phone> findAll();

    Phone findById(int theId);

    void save(Phone phone);

    void deleteById(int theId);
}
