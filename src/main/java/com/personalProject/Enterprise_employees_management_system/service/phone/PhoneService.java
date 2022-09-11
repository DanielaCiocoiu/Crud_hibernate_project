package com.personalProject.Enterprise_employees_management_system.service.phone;

import com.personalProject.Enterprise_employees_management_system.domain.Phone;

import java.util.List;

public interface PhoneService {
     List<Phone> findAll();

     Phone findById(int theId);

     void save(Phone phone);

     void deleteById(int theId);


}
