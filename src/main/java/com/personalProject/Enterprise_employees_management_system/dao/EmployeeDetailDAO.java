package com.personalProject.Enterprise_employees_management_system.dao;

import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;

import java.util.List;

public interface EmployeeDetailDAO {
        List<EmployeeDetail> findAllemployeesDetail();
        EmployeeDetail findByIdemployeeDetailDAO(int theId);
        void saveEmployeeDetail(EmployeeDetail employeeDetail);
        void deleteByIdEmployeeDetail(int theId);
}
