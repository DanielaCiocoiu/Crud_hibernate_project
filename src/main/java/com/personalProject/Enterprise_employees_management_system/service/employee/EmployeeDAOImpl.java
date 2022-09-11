package com.personalProject.Enterprise_employees_management_system.service.employee;

import com.personalProject.Enterprise_employees_management_system.domain.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        //native hibernate api
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public List<Employee> getEmployeeByDepartament() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        final List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);
        // saveOrUpdate - daca id=0 se face save, daca nu - update
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }

}
