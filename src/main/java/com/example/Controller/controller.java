package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class controller {

    @Autowired
    RuleRepository getdata;

    @RequestMapping("/data")
    public List<Model> users(){
        return getdata.findAll();
    }
    @DeleteMapping("/delrules/{id}")
    public void deleteRule(@PathVariable Integer id) {
        getdata.deleteById(id);
    }
    @PutMapping("/updrules/{id}")
    public ResponseEntity<Object> updateRule(@RequestBody Model rule, @PathVariable Integer id) {

        Optional<Model> ruleOptional = getdata.findById(id);

        if (!ruleOptional.isPresent())
            return ResponseEntity.notFound().build();

        rule.setId(id);

        getdata.save(rule);

        return ResponseEntity.noContent().build();
    }
    @PostMapping("/addrule")
    public ResponseEntity<Object> createRule(@RequestBody Model rule) {
        Model savedRule = getdata.save(rule);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedRule.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


}
