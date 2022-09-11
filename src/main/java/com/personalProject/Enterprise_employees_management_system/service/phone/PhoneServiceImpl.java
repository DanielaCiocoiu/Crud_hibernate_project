package com.personalProject.Enterprise_employees_management_system.service.phone;

import com.personalProject.Enterprise_employees_management_system.domain.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService{

    private PhoneDAO phoneDAO;

    public PhoneServiceImpl(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    @Transactional
    public List<Phone> findAll() {
        return phoneDAO.findAll();
    }

    @Override
    @Transactional
    public Phone findById(int theId) {
        return phoneDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Phone phone) {
        phoneDAO.save( phone );
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        phoneDAO.deleteById(theId );
    }

}
