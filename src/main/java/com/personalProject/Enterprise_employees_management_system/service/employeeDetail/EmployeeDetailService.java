package com.personalProject.Enterprise_employees_management_system.service.employeeDetail;

import com.personalProject.Enterprise_employees_management_system.domain.EmployeeDetail;

import java.util.List;

public interface EmployeeDetailService {
     List<EmployeeDetail> findAllEmployeeDetail();
     EmployeeDetail findByIdEmployeeDetail(int theId);
     void saveEmployeeDetail(EmployeeDetail employeeDetail);
     void deleteByIdEmployeeDetail(int theId);


}
