package com.workintech.S17D2.model;

import com.workintech.S17D2.model.enums.Experience;

public class JuniorDeveloper extends Developer {
    public JuniorDeveloper(int id, String name, double salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}
