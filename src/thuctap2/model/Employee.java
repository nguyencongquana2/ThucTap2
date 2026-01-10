package thuctap2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Employee {
    private static int cnt = 1;
         private String id, name, gender, adress;
         private LocalDate birthDate;

         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

         public Employee(String name, String gender, LocalDate birthDate, String address) {
             this.id = String.format("NV%02d", cnt++);
             this.name = name;
             this.gender = gender;
             this.adress = address;
             this.birthDate = birthDate;
         }

         public String getId() {
             return id;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getGender() {
             return gender;
         }

         public void setGender(String gender) {
             this.gender = gender;
         }

         public String getAdress() {
             return adress;
         }

         public void setAdress(String adress) {
             this.adress = adress;
         }

        public int getAge(){
             LocalDate currentDate = LocalDate.now();
             return currentDate.getYear() - birthDate.getYear();
        }

         public abstract double getSalary();

         public abstract String getType();

         public String getInfo(){
             return id +" "+ name +" "+ gender + " "+ adress +" "+ birthDate.format(dtf);
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