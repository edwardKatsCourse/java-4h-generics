package com.company.user_employee;

public class Main {

    public static void main(String[] args) {
	    //Generics
        //1. Creation: creation + usage
        //2. Restrictions
        //3. Assigning: covariant, contravariant, invariant
        //Covariant:            String -> Object
        //Invariant:            String -> String
        //Contravariant:        Integer <- Number

        /**
         * Typical usage:
         * 1. Collections/iterators/containers
         * 2. Parent
         */

        //             Employee
        //RegularEmployee   ManagerEmployee

        RegularEmployee regularEmployee = new RegularEmployee("Java Developer", 15000.);
        ManagerEmployee manager = new ManagerEmployee("Java Developer Team Leader", 20000.);

        User<Employee> user = new User<>("John Doe", 41, regularEmployee);

        User<Employee> user2 = new User<>("Anna Smith", 45, manager);

        System.out.println(user.toString());
        System.out.println(user2.toString());
    }
}

class User<T extends Employee> {

    private String name;
    private Integer age;
    private T employee;

    public User(String name, Integer age, T employee) {
        this.name = name;
        this.age = age;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Age: %s | Position: %s | Salary: %s",
                this.name,
                this.age,
                this.employee.getPosition(),
                this.employee.getBaseSalary());
    }
}

class Employee {
    private String position;
    private Double baseSalary;

    public Employee(String position, Double baseSalary) {
        this.position = position;
        this.baseSalary = baseSalary;
    }

    public String getPosition() {
        return position;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }
}
class RegularEmployee extends Employee {

    private static final Double multiplier = 1.1;
    public RegularEmployee(String position, Double baseSalary) {
        super(position, baseSalary);
    }

    public void regularEmployeeMethod() {}

    @Override
    public Double getBaseSalary() {
        return super.getBaseSalary() * multiplier;
    }
}

class ManagerEmployee extends Employee {

    private static final Double multiplier = 1.5;

    public ManagerEmployee(String position, Double baseSalary) {
        super(position, baseSalary);
    }

    public void managerEmployeeMethod() {}

    @Override
    public Double getBaseSalary() {
        return super.getBaseSalary() * multiplier;
    }
}
