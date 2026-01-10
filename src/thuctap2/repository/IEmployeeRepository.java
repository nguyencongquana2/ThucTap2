package thuctap2.repository;

import thuctap2.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll() ;

    void save(Employee nv);

    boolean deleteById(String id);

    void loadFromFile(String path);

    void saveToFile(String path);
}
