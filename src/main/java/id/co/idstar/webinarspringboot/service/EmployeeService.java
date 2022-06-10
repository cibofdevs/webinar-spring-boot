package id.co.idstar.webinarspringboot.service;

import id.co.idstar.webinarspringboot.model.request.CreateEmployeeRequest;
import id.co.idstar.webinarspringboot.model.request.UpdateEmployeeRequest;
import id.co.idstar.webinarspringboot.model.database.Employee;

import java.util.List;

public interface EmployeeService {

    void create(CreateEmployeeRequest request);

    void update(int id, UpdateEmployeeRequest request);

    List<Employee> findAll(int page, int size);

    Employee findById(int id);

    void delete(int id);
}
