package com.personalProject.Enterprise_employees_management_system.dao;

import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDetailDAOImpl implements EmployeeDetailDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeDetail> findAllemployeesDetail() {

        Session currentSession = entityManager.unwrap(Session.class);
        //native hibernate api
        Query<EmployeeDetail> theQuery = currentSession.createQuery("from employee_detail", EmployeeDetail.class);

        List<EmployeeDetail> employeesDetail = theQuery.getResultList();
        return employeesDetail;

    }

    @Override
    public EmployeeDetail findByIdemployeeDetailDAO(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        EmployeeDetail employeeDetail = currentSession.get(EmployeeDetail.class, theId);

        return employeeDetail;
    }

    @Override
    public void saveEmployeeDetail(EmployeeDetail employeeDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employeeDetail);
       // saveOrUpdate - daca id=0 se face save, daca nu - update
    }

    @Override
    public void deleteByIdEmployeeDetail(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from employee_detail where id=:id_emp_detail");
        theQuery.setParameter("id_emp_detail", theId);
        theQuery.executeUpdate();
    }



}
