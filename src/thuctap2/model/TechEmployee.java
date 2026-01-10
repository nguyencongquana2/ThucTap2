package thuctap2.model;

import java.time.LocalDate;

public class TechEmployee extends Employee {
    private double baseIncome;
    private double hoursOT;


    public TechEmployee(String name, String gender, LocalDate birthDate, String address, double baseIncome, double hoursOT) {
        super(name, gender, birthDate, address);
        this.baseIncome = baseIncome;
        this.hoursOT = hoursOT;
    }

    @Override
    public double getSalary() {
        return baseIncome + hoursOT * 200000;
    }

    @Override
    public String getType() {
        return "Tech";
    }

    @Override
    public String getInfo(){
        return super.getInfo() + " " + baseIncome + " " + hoursOT;
    }
}