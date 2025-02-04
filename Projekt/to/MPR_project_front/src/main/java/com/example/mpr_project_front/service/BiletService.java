package com.example.mpr_project_front.service;


import com.example.mpr_project_front.exception.BiletExist;
import com.example.mpr_project_front.exception.BiletNotFoundException;
import com.example.mpr_project_front.model.Bilets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Component
public class BiletService {
    private final RestClient restClient;

    @Autowired
    public BiletService(RestClient restClient){
        this.restClient = restClient;
    }

    public Bilets getBiletByNameP(String nameP) {
        String result = restClient.get()
                .uri("bilet/name/" + nameP)
                .retrieve()
                .body(String.class);

        return null;
    }

    public List<Bilets> getAllBilety() {
        List<Bilets> biletsList = restClient.get()
                .uri("bilet/all")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Bilets>>() {});
        if(biletsList.isEmpty()) {
            throw new BiletNotFoundException();
        }
        return biletsList;
    }

    public void addBilet(Bilets bilets) {
        List<Bilets> existing = restClient.get()
                .uri("bilet/all")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Bilets>>() {});
        boolean exists = existing.stream()
                .anyMatch(b -> b.getNameP().equalsIgnoreCase(bilets.getNameP()));
        if (exists) {
            throw new BiletExist();
        }
        try {
            ResponseEntity<Void> responseEntity = restClient.post()
                    .uri("bilet/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(bilets)
                    .retrieve()
                    .toBodilessEntity();
        } catch (RestClientException e) {
            throw new RuntimeException();
        }
    }

    public Bilets get(Long id) {
        Bilets result = restClient.get()
                .uri("bilet/" + id)
                .retrieve()
                .body(Bilets.class);

        return result;
    }

    public void deleteBilet(Long id) {
        ResponseEntity<Void> responseEntity = restClient.delete()
                .uri("bilet/delete/" + id)
                .retrieve()
                .toBodilessEntity();
    }

    public void updateBilet(Long id, Bilets bilets) {
        ResponseEntity<Void> responseEntity = restClient.put()
                .uri("bilet/update/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(bilets)
                .retrieve()
                .toBodilessEntity();
    }
}


