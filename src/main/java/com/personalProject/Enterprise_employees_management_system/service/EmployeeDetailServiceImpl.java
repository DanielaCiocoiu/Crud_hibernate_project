package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.dao.EmployeeDetailDAO;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService{

    private EmployeeDetailDAO employeeDetailDAO;

    public EmployeeDetailServiceImpl(EmployeeDetailDAO employeeDetailDAO) {
        this.employeeDetailDAO = employeeDetailDAO;
    }

    @Override
    @Transactional
    public List<EmployeeDetail> findAllEmployeeDetail() {
        return employeeDetailDAO.findAllemployeesDetail();
    }

    @Override
    @Transactional
    public EmployeeDetail findByIdEmployeeDetail(int theId) {
        return employeeDetailDAO.findByIdemployeeDetailDAO(theId);
    }

    @Override
    @Transactional
    public void saveEmployeeDetail(EmployeeDetail theEmployee) {
        employeeDetailDAO.saveEmployeeDetail(theEmployee );
    }

    @Override
    @Transactional
    public void deleteByIdEmployeeDetail(int theId) {
        employeeDetailDAO.deleteByIdEmployeeDetail(theId );
    }

}
