package com.workintech.S17D2.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S17D2.model.Developer;
import com.workintech.S17D2.model.JuniorDeveloper;
import com.workintech.S17D2.model.MidDeveloper;
import com.workintech.S17D2.model.SeniorDeveloper;
import com.workintech.S17D2.model.enums.Experience;
import com.workintech.S17D2.tax.Taxable;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable tax;

    @PostConstruct
    public void init() {
        developers = new HashMap<>();
    }

    @Autowired
    public DeveloperController(@Qualifier("developerTax") Taxable tax) {
        this.tax = tax;
    }

    @GetMapping("/")
    public List<Developer> getList() {
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable int id) {
        return developers.get(id);
    }

    @PostMapping("/")
    public Developer addDeveloper(@RequestBody Map<String, Object> payload) {
        int id = developers.size() + 1;
        String name = (String) payload.get("name");
        double salary = (double) payload.get("salary");
        Experience experience = (Experience) Experience.valueOf((String) payload.get("experience"));
        Developer developer = null;

        if (experience == Experience.JUNIOR) {
            salary = salary - (salary * tax.getSimpleTaxRate());
            developer = new JuniorDeveloper(id, name, salary);
        } else if (experience == Experience.MID) {
            salary = salary - (salary * tax.getMiddleTaxRate());
            developer = new MidDeveloper(id, name, salary);
        } else if (experience == Experience.SENIOR) {
            salary = salary - (salary * tax.getUpperTaxRate());
            developer = new SeniorDeveloper(id, name, salary);
        }

        developers.put(id, developer);
        return developer;
    }

    @PutMapping("/{id}")
    public Developer updateDeveloper(@PathVariable int id, @RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        double salary = (double) payload.get("salary");
        Experience experience = (Experience) Experience.valueOf((String) payload.get("experience"));
        Developer developer = null;

        if (experience == Experience.JUNIOR) {
            salary = salary - (salary * tax.getSimpleTaxRate());
            developer = new JuniorDeveloper(id, name, salary);
        } else if (experience == Experience.MID) {
            salary = salary - (salary * tax.getMiddleTaxRate());
            developer = new MidDeveloper(id, name, salary);
        } else if (experience == Experience.SENIOR) {
            salary = salary - (salary * tax.getUpperTaxRate());
            developer = new SeniorDeveloper(id, name, salary);
        }

        developers.put(id, developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable int id) {
        developers.remove(id);
    }

}