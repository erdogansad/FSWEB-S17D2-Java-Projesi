package com.workintech.S17D2.model;

import com.workintech.S17D2.model.enums.Experience;

public class MidDeveloper extends Developer {
    public MidDeveloper(int id, String name, double salary) {
        super(id, name, salary, Experience.MID);
    }
}
