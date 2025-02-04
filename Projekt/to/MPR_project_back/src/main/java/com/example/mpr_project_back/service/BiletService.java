package com.example.mpr_project_back.service;



import com.example.mpr_project_back.model.Bilet;
import com.example.mpr_project_back.repository.BiletRepository;
import com.example.mpr_project_back.exception.BiletNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BiletService {

    private BiletRepository biletRepository;



    @Autowired
    public BiletService(BiletRepository repository) {
        this.biletRepository = repository;
    }

    public List<Bilet> getBiletByNameP(String nameP) {
        List<Bilet> biletList = this.biletRepository.findByNameP(nameP);
        if(biletList.isEmpty()) {
            throw new BiletNotFoundException();
        }
        return biletList;
    }

    public List<Bilet> findBiletByMiejsceWylotu(String miejsceWylotu) {
        List<Bilet> bilety = this.biletRepository.findByMiejsceWylotu(miejsceWylotu);
        if (bilety.isEmpty()) {
            throw new BiletNotFoundException();
        }
        return bilety;
    }

    public List<Bilet> findBiletByMiejscePrzylotu(String miejscePrzylotu) {
        List<Bilet> bilety = this.biletRepository.findByMiejscePrzylotu(miejscePrzylotu);
        if (bilety.isEmpty()) {
            throw new BiletNotFoundException();
        }
        return bilety;
    }

    public List<Bilet> getAllBilety() {
        List<Bilet> biletList = (List<Bilet>) this.biletRepository.findAll();
        if(biletList.isEmpty()){
            throw new BiletNotFoundException();
        }
        return biletList;
    }

    public void addBilet(Bilet bilet) {
        if (bilet.getNameP() == null || bilet.getNameP().isEmpty() ||
                bilet.getMiejsceWylotu() == null || bilet.getMiejsceWylotu().isEmpty() ||
                bilet.getMiejscePrzylotu() == null || bilet.getMiejscePrzylotu().isEmpty() ||
                bilet.getNumerSiedzenia() == null || bilet.getNumerSiedzenia().isEmpty()) {
            throw new IllegalArgumentException("All fields must be filled");
        }
        this.biletRepository.save(bilet);
    }

    public Bilet get(Long id) {
        Optional<Bilet> bilet = this.biletRepository.findById(id);
        if(bilet.isEmpty()){
            throw new BiletNotFoundException();
        }
        return bilet.get();
    }

    public void deleteBilet(Long id) {
        if (!this.biletRepository.existsById(id)) {
            throw new BiletNotFoundException();
        }
        this.biletRepository.deleteById(id);
    }

    public void updateBilet(Long id, Bilet bilet) {
        Optional<Bilet> existingBilet = this.biletRepository.findById(id);
        if (existingBilet.isPresent()) {
            Bilet currentBilet = existingBilet.get();
            if (bilet.getNameP() != null) currentBilet.setNameP(bilet.getNameP());
            if (bilet.getMiejsceWylotu() != null) currentBilet.setMiejsceWylotu(bilet.getMiejsceWylotu());
            if (bilet.getMiejscePrzylotu() != null) currentBilet.setMiejscePrzylotu(bilet.getMiejscePrzylotu());
            if (bilet.getNumerSiedzenia() != null) currentBilet.setNumerSiedzenia(bilet.getNumerSiedzenia());
            this.biletRepository.save(currentBilet);
        } else {
            throw new BiletNotFoundException();
        }
    }
}
