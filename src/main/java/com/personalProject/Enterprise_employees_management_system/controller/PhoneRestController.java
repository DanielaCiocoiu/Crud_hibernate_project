package com.personalProject.Enterprise_employees_management_system.controller;

import com.personalProject.Enterprise_employees_management_system.domain.Phone;
import com.personalProject.Enterprise_employees_management_system.error.PhoneNotFoundException;
import com.personalProject.Enterprise_employees_management_system.service.phone.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneRestController {
    private PhoneService phoneService;

    public PhoneRestController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/phones")
    public List<Phone> findAll() {
        return phoneService.findAll();
    }



    @GetMapping("/phones/{phoneId}")
    public Phone getPhone(@PathVariable int phoneId) {
        Phone phone = phoneService.findById(phoneId);
        if ((phone == null) || (phoneId < 0)) {
            throw new PhoneNotFoundException("EmployeeDetail id not found - " + phoneId);
        }
        return phone;
    }

    @PostMapping("/phones")
    @ResponseStatus(HttpStatus.CREATED)
    public Phone addPhone(@RequestBody Phone phone) {
        phone.setId(0);
        phoneService.save(phone);
        return phone;
    }

    @PutMapping("/phones")
    @ResponseStatus(HttpStatus.OK)
    public Phone savePhone(@RequestBody Phone phone) {
        phoneService.save(phone);
        return phone;
    }

    @DeleteMapping("/phones/{phoneId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByIdPhone(@PathVariable int phoneId) {
        phoneService.deleteById(phoneId);
        return "Deleted employeeDetail id - " + phoneId;
    }

}
