package entity;

import java.util.List;

public class Employee extends Person {

    int salary;
    String jobTitle;

    public Employee(String name, String email, List<Skill> skillSet) {super(name, email, skillSet);}

    public int getSalary() {
        return salary;
    }
    public String getJobTitle() {
        return jobTitle;
    }
}
