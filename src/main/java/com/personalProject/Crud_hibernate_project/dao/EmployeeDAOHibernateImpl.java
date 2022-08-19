package com.personalProject.Crud_hibernate_project.dao;

import com.personalProject.Crud_hibernate_project.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
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
