import thuctap2.controller.EmployeeController;
import thuctap2.model.AdminEmployee;
import thuctap2.model.Employee;
import thuctap2.model.TechEmployee;
import thuctap2.repository.FileEmployeeRepository;
import thuctap2.service.EmployeeService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileEmployeeRepository repo = new FileEmployeeRepository();
        EmployeeService service = new EmployeeService(repo);
        EmployeeController controller = new EmployeeController(service);

        controller.run();
    }
}