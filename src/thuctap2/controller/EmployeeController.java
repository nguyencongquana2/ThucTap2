package thuctap2.controller;

import thuctap2.model.AdminEmployee;
import thuctap2.model.Employee;
import thuctap2.model.TechEmployee;
import thuctap2.service.EmployeeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeService service;
    private Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    public void run() {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    loadFromFile();
                    break;
                case 2:
                    service.showAll();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    service.sortByIncomeDesc();
                    break;
                case 6:
                    service.statisticByType();
                    break;
                case 7:
                    saveToFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Load danh sách từ file");
        System.out.println("2. Hiển thị danh sách nhân viên");
        System.out.println("3. Thêm nhân viên");
        System.out.println("4. Xóa nhân viên theo ID");
        System.out.println("5. Sắp xếp theo lương giảm dần");
        System.out.println("6. Thống kê theo loại");
        System.out.println("7. Lưu danh sách ra file");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    private void loadFromFile() {
        System.out.print("Nhập đường dẫn file: ");
        String path = sc.nextLine();
        service.load(path);
        System.out.println("Load thành công!");
    }

    private void saveToFile() {
        System.out.print("Nhập đường dẫn file: ");
        String path = sc.nextLine();
        service.save(path);
        System.out.println("Lưu thành công!");
    }

    private void removeEmployee() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();
        service.removeById(id);
    }

    private void addEmployee() {
        System.out.println("1. Admin");
        System.out.println("2. Tech");
        System.out.print("Chọn loại nhân viên: ");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Giới tính: ");
        String gender = sc.nextLine();

        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), dtf);

        System.out.print("Địa chỉ: ");
        String address = sc.nextLine();

        Employee e = null;

        if (type == 1) {
            System.out.print("Lương cơ bản: ");
            double base = Double.parseDouble(sc.nextLine());

            System.out.print("Số ngày công: ");
            int days = Integer.parseInt(sc.nextLine());

            e = new AdminEmployee(name, gender, birthDate, address, base, days);
        }
        else if (type == 2) {
            System.out.print("Lương cơ bản: ");
            double base = Double.parseDouble(sc.nextLine());

            System.out.print("Số giờ OT: ");
            double ot = Double.parseDouble(sc.nextLine());

            e = new TechEmployee(name, gender, birthDate, address, base, ot);
        }

        if (e != null) {
            service.addEmployee(e);
            System.out.println("Thêm nhân viên thành công!");
        }
    }
}
