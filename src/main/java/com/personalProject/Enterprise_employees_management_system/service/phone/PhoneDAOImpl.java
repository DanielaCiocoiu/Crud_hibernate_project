package com.personalProject.Enterprise_employees_management_system.service.phone;

import com.personalProject.Enterprise_employees_management_system.domain.Phone;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

    private EntityManager entityManager;

    @Autowired
    public PhoneDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Phone> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        //native hibernate api
        Query<Phone> theQuery = currentSession.createQuery("from Phone", Phone.class);

        List<Phone> phones = theQuery.getResultList();
        return phones;

    }

    @Override
    public Phone findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Phone phone = currentSession.get(Phone.class, theId);

        return phone;
    }

    @Override
    public void save(Phone phone) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(phone);
        // saveOrUpdate - daca id=0 se face save, daca nu - update
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Phone where id=:phoneId");
        theQuery.setParameter("phoneId", theId);
        theQuery.executeUpdate();
    }

}
