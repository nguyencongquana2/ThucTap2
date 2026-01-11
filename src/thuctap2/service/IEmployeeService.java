package thuctap2.service;

import thuctap2.model.Employee;

public interface IEmployeeService {
    void load(String path);

    void showAll();

    void addEmployee(Employee e);

    void removeById(String id);

    void sortByIncomeDesc();

    void statisticByType();

    void save(String path);
}
