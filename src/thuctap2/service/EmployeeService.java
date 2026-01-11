package thuctap2.service;

import thuctap2.exception.InvalidEmployeeException;
import thuctap2.model.Employee;
import thuctap2.repository.FileEmployeeRepository;
import thuctap2.repository.IEmployeeRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository repo;

    public EmployeeService(IEmployeeRepository repos) {
        this.repo = repos;
    }

    @Override
    public void load(String path) {
        repo.loadFromFile(path);
    }

    @Override
    public void showAll() {
        List<Employee> list = repo.findAll();
        if(list.isEmpty()) {
            System.out.println("Danh sách rỗng");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void addEmployee(Employee e) {
        if (e.getBirthDate().isAfter(LocalDate.now())) {
            throw new InvalidEmployeeException("Ngày sinh không được lớn hơn hiện tại");
        }

        if (e.getIncome() <= 0) {
            throw new InvalidEmployeeException("Thu nhập phải > 0");
        }
        repo.save(e);
    }

    @Override
    public void removeById(String id) {
        boolean removed = repo.deleteById(id);
        if (!removed) {
            System.out.println("Không tìm thấy ID: " + id);
        }
    }

    @Override
    public void sortByIncomeDesc() {
        repo.findAll().sort((e1, e2) -> Double.compare(e2.getIncome(), e1.getIncome()));
        System.out.println("Da sap xep theo danh sach giam dan!");
    }

    @Override
    public void statisticByType() {
        List<Employee> list = repo.findAll();
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        System.out.println("=== Thống kê nhân viên theo phòng ban ===");
        for(Employee e : list){
            String type = e.getType();
            map.put(type, map.getOrDefault(type, 0) +1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() +": " + entry.getValue());
        }
    }

    @Override
    public void save(String path) {
        repo.saveToFile(path);
    }

}
