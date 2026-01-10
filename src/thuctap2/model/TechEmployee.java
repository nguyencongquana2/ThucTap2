package thuctap2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TechEmployee extends Employee {
    private double baseIncome;
    private double hoursOT;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TechEmployee(String name, String gender, LocalDate birthDate, String address, double baseIncome, double hoursOT) {
        super(name, gender, birthDate, address);
        this.baseIncome = baseIncome;
        this.hoursOT = hoursOT;
    }

    @Override
    public String toFileString() {
        return String.format(
                "KT;%s;%s;%s;%s;%.0f;%.0f",
                name, gender, birthDate.format(dtf),
                address, baseIncome, hoursOT
        );
    }

    @Override
    public double getIncome() {
        return baseIncome + hoursOT * 200000;
    }

    @Override
    public String getType() {
        return "TECHNICAL";
    }

}