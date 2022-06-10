package id.co.idstar.webinarspringboot.service.impl;

import id.co.idstar.webinarspringboot.model.request.CreateEmployeeRequest;
import id.co.idstar.webinarspringboot.model.request.UpdateEmployeeRequest;
import id.co.idstar.webinarspringboot.model.database.Employee;
import id.co.idstar.webinarspringboot.repository.EmployeeRepository;
import id.co.idstar.webinarspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setAddress(request.getAddress());
        employeeRepository.save(employee);
    }

    @Override
    public void update(int id, UpdateEmployeeRequest request) {
        Employee employee = findById(id);
        employee.setAddress(request.getAddress());
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll(int page, int size) {
        // page -> 0, can't minus
        // size -> 0, can't minus
        PageRequest pageRequest = PageRequest.of(page, size);
        return employeeRepository.findAll(pageRequest)
                .getContent();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(int id) {
        findById(id);
        employeeRepository.deleteById(id);
    }
}
