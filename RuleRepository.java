package com.example.Controller;

import com.example.Controller.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RuleRepository extends JpaRepository<Model, Integer> {
    @Override
    List<Model> findAll();
}

