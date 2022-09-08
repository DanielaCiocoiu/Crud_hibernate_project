package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.entity.Phone;

import java.util.List;

public interface PhoneService {
     List<Phone> findAll();

     Phone findById(int theId);

     void save(Phone phone);

     void deleteById(int theId);


}
