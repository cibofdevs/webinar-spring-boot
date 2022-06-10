package id.co.idstar.webinarspringboot.repository;

import id.co.idstar.webinarspringboot.model.database.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);
    Employee findByNameAndAddress(String name, String address);

    @Query("SELECT name FROM Employee WHERE name LIKE '%John%'")
    List<Employee> findAllByRegexName(String name);
}
