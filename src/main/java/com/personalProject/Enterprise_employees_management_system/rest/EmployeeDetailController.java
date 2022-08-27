package com.personalProject.Enterprise_employees_management_system.rest;

import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;
import com.personalProject.Enterprise_employees_management_system.service.EmployeeDetailService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeDetailController {
    private EmployeeDetailService employeeDetailService;

    public EmployeeDetailController(EmployeeDetailService employeeDetailService) {
        this.employeeDetailService = employeeDetailService;
    }

    @GetMapping("/employeesDetail")
    @Cacheable(value = "cacheEmployeesDetail")
    public List<EmployeeDetail> findAll() {
        return employeeDetailService.findAllEmployeeDetail();
    }



    @GetMapping("/employeesDetail/{employeeIdDetail}")
    public EmployeeDetail getEmployee(@PathVariable int employeeIdDetail) {
        EmployeeDetail theEmployee = employeeDetailService.findByIdEmployeeDetail(employeeIdDetail);
        if ((theEmployee == null) || (employeeIdDetail < 0)) {
            throw new EmplyeeNotFoundException("EmployeeDetail id not found - " + employeeIdDetail);
        }
        return theEmployee;
    }

    @PostMapping("/employeesDetail")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDetail addEmployee(@RequestBody EmployeeDetail employeeDetail) {
        employeeDetail.setIdEmployeeDetail(0);
        employeeDetailService.saveEmployeeDetail(employeeDetail);
        return employeeDetail;
    }

    @PutMapping("/employeesDetail")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDetail saveEmployeeDetail(@RequestBody EmployeeDetail employeeDetail) {
        employeeDetailService.saveEmployeeDetail(employeeDetail);
        return employeeDetail;
    }

    @DeleteMapping("/employeesDetail/{employeeIdDetail}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByIdEmployeeDetail(@PathVariable int employeeIdDetail) {
        employeeDetailService.deleteByIdEmployeeDetail(employeeIdDetail);
        return "Deleted employeeDetail id - " + employeeIdDetail;
    }

}
