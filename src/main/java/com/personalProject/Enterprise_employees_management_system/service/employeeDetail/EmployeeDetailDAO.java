package com.personalProject.Enterprise_employees_management_system.service.employeeDetail;

import com.personalProject.Enterprise_employees_management_system.domain.EmployeeDetail;

import java.util.List;

public interface EmployeeDetailDAO {
        List<EmployeeDetail> findAllemployeesDetail();
        EmployeeDetail findByIdemployeeDetailDAO(int theId);
        void saveEmployeeDetail(EmployeeDetail employeeDetail);
        void deleteByIdEmployeeDetail(int theId);
}
