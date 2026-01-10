package thuctap2.model;

import java.time.LocalDate;

public class AdminEmployee extends Employee {
    private double baseIncome;
    private int daysWork;

    public AdminEmployee(String name, String gender, LocalDate birthDate, String address, double baseIncome, int daysWork) {
        super(name, gender, birthDate, address);
        this.baseIncome = baseIncome;
        this.daysWork = daysWork;
    }

    @Override
    public double getSalary() {
        return baseIncome * daysWork;
    }

    @Override
    public String getType() {
        return "Admin";
    }

    @Override
    public String getInfo(){
        return super.getInfo() + " " + baseIncome + " " + daysWork;
    }
}