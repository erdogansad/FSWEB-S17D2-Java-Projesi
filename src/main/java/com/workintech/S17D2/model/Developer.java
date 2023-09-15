package com.workintech.S17D2.model;

import com.workintech.S17D2.model.enums.Experience;

public class Developer {
    protected int id;
    protected String name;
    protected double salary;
    protected Experience experience;

    public Developer(int id, String name, double salary, Experience experience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Experience getExperience() {
        return experience;
    }

    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
