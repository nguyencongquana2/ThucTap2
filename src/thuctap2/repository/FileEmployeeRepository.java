package thuctap2.repository;

import thuctap2.model.AdminEmployee;
import thuctap2.model.Employee;
import thuctap2.model.TechEmployee;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements IEmployeeRepository {
    private List<Employee> list = new ArrayList<>();

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Override
    public List<Employee> findAll() {
        return list;
    }

    @Override
    public void save(Employee nv) {
        list.add(nv);
    }

    @Override
    public boolean deleteById(String id) {
        return list.removeIf(e -> e.getId().equals(id));
    }


    @Override
    public void loadFromFile(String path) {
        list.clear();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                String type = arr[0];
                String name = arr[1];
                String gender = arr[2];

                LocalDate birthDate = LocalDate.parse(arr[3], dtf);
                String address = arr[4];
                if (type.equals("HC")) {
                    double baseIncome = Double.parseDouble(arr[5]);
                    int daysWork = Integer.parseInt(arr[6]);
                    list.add(new AdminEmployee(name, gender, birthDate, address, baseIncome, daysWork));
                } else if (type.equals("KT")) {
                    double baseIncome = Double.parseDouble(arr[5]);
                    double hoursOT = Double.parseDouble(arr[6]);
                    list.add(new TechEmployee(name, gender, birthDate, address, baseIncome, hoursOT));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void saveToFile(String path) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (Employee e : list) {
                bw.write(e.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
