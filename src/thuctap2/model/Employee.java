package thuctap2.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Employee {
    private static int cnt = 1;
    protected String id, name, gender, address;
    protected LocalDate birthDate;

    public Employee(String name, String gender, LocalDate birthDate, String address) {
        this.id = String.format("NV%03d", cnt++);
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getId() {
             return id;
    }

    public int getAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public abstract double getIncome();

    public abstract String getType();

    public abstract String toFileString();

    @Override
    public String toString() {
        return String.format(
                "%s | %s | %s | %s | %d tuổi | %.0f",
                id, name, gender, getType(), getAge(), getIncome()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return Objects.equals(name, e.name)
                && Objects.equals(birthDate, e.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

}