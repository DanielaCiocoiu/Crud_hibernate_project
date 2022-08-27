package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;

import java.util.List;

public interface EmployeeDetailService {
     List<EmployeeDetail> findAllEmployeeDetail();
     EmployeeDetail findByIdEmployeeDetail(int theId);
     void saveEmployeeDetail(EmployeeDetail employeeDetail);
     void deleteByIdEmployeeDetail(int theId);


}
