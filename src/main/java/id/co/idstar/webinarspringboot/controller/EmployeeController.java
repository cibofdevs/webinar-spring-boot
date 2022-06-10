package id.co.idstar.webinarspringboot.controller;

import id.co.idstar.webinarspringboot.model.request.CreateEmployeeRequest;
import id.co.idstar.webinarspringboot.model.request.UpdateEmployeeRequest;
import id.co.idstar.webinarspringboot.model.database.Employee;
import id.co.idstar.webinarspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateEmployeeRequest request) {
        employeeService.create(request);
    }

    @PutMapping(value = "/employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody UpdateEmployeeRequest request) {
        employeeService.update(id, request);
    }

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return employeeService.findAll(page, size);
    }

    @GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @DeleteMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
