package entity;

import java.util.List;

public class Person {

    String name;
    String email;
    List<Skill> skillSet;

    public Person(String name, String email, List<Skill> skillSet) {
        this.name = name;
        this.email = email;
        this.skillSet = skillSet; }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<Skill> getSkillSet() {
        return skillSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return email.equals(person.email); }

    @Override
    public int hashCode() {return email.hashCode();}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", skillSet=" + skillSet +
                '}'; }
}
