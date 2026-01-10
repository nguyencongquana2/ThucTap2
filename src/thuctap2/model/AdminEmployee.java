package thuctap2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AdminEmployee extends Employee {
    private double baseIncome;
    private int daysWork;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AdminEmployee(String name, String gender, LocalDate birthDate, String address, double baseIncome, int daysWork) {
        super(name, gender, birthDate, address);
        this.baseIncome = baseIncome;
        this.daysWork = daysWork;
    }

    @Override
    public double getIncome() {
        return baseIncome * daysWork;
    }

    @Override
    public String toFileString() {
        return String.format(
                "HC;%s;%s;%s;%s;%.0f;%d",
                name, gender, birthDate.format(dtf),
                address, baseIncome, daysWork
        );
    }

    @Override
    public String getType() {
        return "ADMINISTRATIVE";
    }
}
