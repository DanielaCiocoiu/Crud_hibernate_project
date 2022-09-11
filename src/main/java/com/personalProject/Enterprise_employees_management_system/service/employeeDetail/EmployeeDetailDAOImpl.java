package com.personalProject.Enterprise_employees_management_system.service.employeeDetail;

import com.personalProject.Enterprise_employees_management_system.domain.EmployeeDetail;
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
        employeeDetail.setAddress(employeeDetail.getAddress());
        employeeDetail.setSalary(employeeDetail.getSalary());
        currentSession.saveOrUpdate(employeeDetail);
        // saveOrUpdate - daca id=0 se face save, daca nu - update
    }

    @Override
    public void deleteByIdEmployeeDetail(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from EmployeeDetail where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}