package com.example.mpr_project_back.repository;

import com.example.mpr_project_back.model.Bilet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiletRepository extends CrudRepository<Bilet, Long> {
    public List<Bilet> findByNameP(String nameP);
    public List<Bilet> findByMiejsceWylotu(String miejsceWylotu);
    public List<Bilet> findByMiejscePrzylotu(String miejscePrzylotu);
}