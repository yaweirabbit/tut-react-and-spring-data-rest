package com.greglturnquist.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huy4 on 27/1/2017.
 */
@RestController
public class EmployeeController {

    private final EmployeeRepository repository;
    private final ManagerRepository managerRepository;

    @Autowired
    public EmployeeController(EmployeeRepository repository, ManagerRepository managerRepository) {
        this.repository = repository;
        this.managerRepository = managerRepository;
    }

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }
}
